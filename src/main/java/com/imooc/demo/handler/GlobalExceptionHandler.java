package com.imooc.demo.handler;

import com.imooc.demo.entity.ResultModel;
import com.imooc.demo.exception.DictException;
import com.imooc.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>标题: 统一异常重写处理</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 15:44
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    private ResultModel exceptionHandler(HttpServletRequest req, Exception e){
        if (e instanceof DictException){
            DictException dictException = (DictException) e;
            return ResultUtil.error(dictException.getCode(), dictException.getMessage());
        } else {
            logger.error("系统异常{}", e);
            return ResultUtil.error(-1,"未知错误：" + e.getMessage());
        }
    }
}
