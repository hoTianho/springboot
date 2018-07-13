package com.imooc.demo.testdynamic;

import com.imooc.demo.testpattern.RealSubject;
import com.imooc.demo.testpattern.Subject;

import java.lang.reflect.Proxy;

/**
 * <p>标题: 价表管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 11:17
 */
public class Client {

    public static void main(String[] args){
        //用于查看代理生成的编码内容
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //newProxyInstance三个参数
        //getProxyClass0、ProxyClassFactory、ProxyGenerator
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{Subject.class},new jdkProxySubject(new RealSubject()));
        subject.request();
        subject.hello();
    }
}
