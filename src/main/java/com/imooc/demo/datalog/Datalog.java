package com.imooc.demo.datalog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <p>标题: 获取字段中文名</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-07-02 11:15
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface Datalog {

    //中文字段名
    String name();
}
