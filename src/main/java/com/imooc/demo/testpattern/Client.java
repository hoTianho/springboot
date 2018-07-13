package com.imooc.demo.testpattern;

/**
 * <p>标题: 测试用</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 10:56
 */
public class Client {

    public static void main(String[] args){
        Subject subject = new Proex(new RealSubject());
        subject.request();
    }
}
