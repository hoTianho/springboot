package com.imooc.demo.testchain;

/**
 * <p>标题: 链式调用示例</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 14:28
 */
public class Client {

    static class HandlerA extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }
    static class HandlerB extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }
    static class HandlerC extends Handler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    public static void main(String[] args){
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.execute();
    }
}
