package com.imooc.demo.utils;

import com.imooc.demo.entity.ResultModel;
import com.imooc.demo.enums.ResultEnum;

/**
 * <p>标题: 返回结果工具类</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 17:03
 */
public class ResultUtil {
    public static ResultModel success(Object object){
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setMsg("success");
        resultModel.setData(object);
        return resultModel;
    }

    public static ResultModel success(){
        return success(null);
    }

    public static ResultModel error(Integer code, String msg) {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(code);
        resultModel.setMsg(msg);
        return resultModel;
    }
}
