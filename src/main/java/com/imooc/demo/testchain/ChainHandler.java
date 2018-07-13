package com.imooc.demo.testchain;

/**
 * <p>标题: 价表管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 14:46
 */
public abstract class ChainHandler {

    public void execute(Chain chain){
        handlerPorcess();
        chain.proceed();
    }

    protected abstract void handlerPorcess();
}
