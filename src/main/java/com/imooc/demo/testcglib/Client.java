package com.imooc.demo.testcglib;

import com.imooc.demo.testpattern.RealSubject;
import com.imooc.demo.testpattern.Subject;
import org.springframework.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();
    }
}
