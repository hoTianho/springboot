package com.imooc.demo.exception;

import com.imooc.demo.enums.ResultEnum;

/**
 * <p>标题: 自定义错误提示</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 16:47
 */
public class DictException extends RuntimeException{

    private Integer code;

    public DictException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
