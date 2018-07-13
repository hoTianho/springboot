package com.imooc.demo.testpattern;

/**
 * <p>标题: 目标对象</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 10:50
 */
public class RealSubject implements Subject  {
    @Override
    public void request() {
        System.out.println("real subject execute request");
    }

    @Override
    public void hello() {
        System.out.println("hello subject execute request");
    }
}
