package com.imooc.demo.testdynamic;

import com.imooc.demo.testpattern.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>标题: 相当于AOP的aspect，动态代理对象</p>
 * <p>描述: 只能针对有接口的类的接口方法进行动态代理</p>
 * <p>描述: 接口中不能定义private方法，因此无法对private方法进行代理</p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 11:00
 */
public class jdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public jdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("");
        System.out.println("before");
        Object reasult = null;
        try{
            reasult= method.invoke(realSubject,args);
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            //可以捕获，但根据逻辑还是要抛出异常
            throw e;
        } finally {
            System.out.println("after");
        }
        return reasult;
    }
}
