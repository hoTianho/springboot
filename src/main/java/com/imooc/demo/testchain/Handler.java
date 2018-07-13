package com.imooc.demo.testchain;

/**
 * <p>标题: 链式调用</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-29 14:26
 */
public abstract class Handler {

    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void execute() {
        handleProcess();
        if (successor != null){
            successor.execute();
        }
    }

    protected abstract  void handleProcess();
}
