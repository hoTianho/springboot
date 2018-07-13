package com.imooc.demo.testchain;

import java.util.Arrays;
import java.util.List;

/**
 * <p>标题: 责任链模式的示例</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 14:56
 */
public class ChainClient {

    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handlerPorcess() {
            System.out.println("handler by chain a");
        }
    }
    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handlerPorcess() {
            System.out.println("handler by chain b");
        }
    }
    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handlerPorcess() {
            System.out.println("handler by chain c");
        }
    }

    public static void main( String[] args){
        List<ChainHandler> handlerList = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        Chain chain = new Chain(handlerList);
        chain.proceed();
    }
}
