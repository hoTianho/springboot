package com.imooc.demo.aspect;

import com.imooc.demo.dao.ActionDao;
import com.imooc.demo.entity.Action;
import com.imooc.demo.entity.ActionType;
import com.imooc.demo.entity.ChangeItem;
import com.imooc.demo.utils.DiffUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * <p>标题: 价表管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 16:19
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    ActionDao actionDao;


    @Pointcut("(execution(public * com.imooc.demo.controller.HelloControl.*(..))) || (execution(public * com.imooc.demo.controller.DeptController.*(..)))")
    public void log(){}

    @Pointcut("execution(public * com.imooc.demo.dao.*.save*(..))")
    public void save(){

    }

    @Pointcut("execution(public * com.imooc.demo.dao.*.delete*(..))")
    public void delete(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("-------exec_before---------");
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_name={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("-------exec_end---------");
    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }

    /**
     * 1\判断是什么类型的操作,增加\删除\还是更新
     *  增加/更新 save(Product),通过id区分是增加还是更新
     *  删除delete(id)
     * 2\获取changeitem
     *   (1)新增操作,before直接获取,after记录下新增之后的id
     *   (2)更新操作,before获取操作之前的记录,after获取操作之后的记录,然后diff
     *   (3)删除操作,before根据id取记录
     * 3\保存操作记录
     *    actionType
     *    objectId
     *    objectClass
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("save() || delete()")
    public Object addOperateLog(ProceedingJoinPoint pjp) throws Throwable {
        Object returnObj = null;

        //TODO BEFORE OPERATION init action
        String method = pjp.getSignature().getName();
        ActionType actionType = null;
        Action action = new Action();
        Long id = null;
        Object oldObj = null;
        try{

            if("save".equals(method)){
                //insert or update
                Object obj = pjp.getArgs()[0];
                try{
                    id = Long.valueOf(PropertyUtils.getProperty(obj,"id").toString());
                }catch (Exception e){
                    //ignore
                }
                if(id == null){
                    actionType = ActionType.INSERT;
                    List<ChangeItem> changeItems = DiffUtil.getInsertChangeItems(obj);
                    action.getChanges().addAll(changeItems);
                    action.setObjectClass(obj.getClass().getName());
                }else{
                    actionType = ActionType.UPDATE;
                    action.setObjectId(id);
                    oldObj = DiffUtil.getObjectById(pjp.getTarget(),id);
                    action.setObjectClass(oldObj.getClass().getName());
                }

            }else if("delete".equals(method)){
                id = Long.valueOf(pjp.getArgs()[0].toString());
                actionType = ActionType.DELETE;
                oldObj = DiffUtil.getObjectById(pjp.getTarget(),id);
                ChangeItem changeItem = DiffUtil.getDeleteChangeItem(oldObj);
                action.getChanges().add(changeItem);
                action.setObjectId(Long.valueOf(pjp.getArgs()[0].toString()));
                action.setObjectClass(oldObj.getClass().getName());
            }

            returnObj = pjp.proceed(pjp.getArgs());

            //TODO AFTER OPERATION save action
            action.setActionType(actionType);
            if(ActionType.INSERT == actionType){
                //new id
                Object newId = PropertyUtils.getProperty(returnObj,"id");
                action.setObjectId(Long.valueOf(newId.toString()));

            }else if(ActionType.UPDATE == actionType){
                Object newObj = DiffUtil.getObjectById(pjp.getTarget(),id);
                List<ChangeItem> changeItems = DiffUtil.getChangeItems(oldObj,newObj);
                action.getChanges().addAll(changeItems);
            }

            action.setOperator("admin"); //dynamic get from threadlocal/session
            action.setOperateTime(new Date());
            //保存到数据库Mongo中，暂未实现
            actionDao.save(action);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }

        return returnObj;
    }
}
