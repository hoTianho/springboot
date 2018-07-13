package com.imooc.demo.testchain;

import java.util.List;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 14:45
 */
public class Chain {
    private List<ChainHandler> handlers;
    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed(){
        if (index >= handlers.size()){
            return;
        }
        handlers.get(index++).execute(this);
    }
}
