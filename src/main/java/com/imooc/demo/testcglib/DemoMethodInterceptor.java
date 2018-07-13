package com.imooc.demo.testcglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>标题: cglig动态代理</p>
 * <p>描述: 基于继承来实现代理，因此无法对static、final类进行代理</p>
 * <p>描述: 同样的，无法对private、static方法进行代理</p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 13:53
 */
public class DemoMethodInterceptor  implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before in cglib");
        Object result = null;
        try{
            result = methodProxy.invokeSuper(o, objects);
        }catch (Exception e){
            System.out.println("get ex:" + e.getMessage());
            throw e;
        }finally {
            System.out.println("after in cglib");
        }
        return result;
    }
}
