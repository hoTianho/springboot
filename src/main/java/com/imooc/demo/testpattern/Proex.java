package com.imooc.demo.testpattern;

/**
 * <p>标题: 静态代理对象</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 10:52
 */
public class Proex implements Subject {

    private RealSubject realSubject;

    public Proex(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before");
        try{
            realSubject.request();
        }catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            //代理对象不会改变真正的方法，所以需要抛出异常
            throw e;
        } finally {
            System.out.println("after");
        }
    }

    @Override
    public void hello() {
        System.out.println("before hello");
        try{
            realSubject.request();
        }catch (Exception e) {
            System.out.println("ex-hello:" + e.getMessage());
            //代理对象不会改变真正的方法，所以需要抛出异常
            throw e;
        } finally {
            System.out.println("after hello");
        }
    }
}
