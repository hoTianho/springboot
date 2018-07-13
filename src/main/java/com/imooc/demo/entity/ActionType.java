package com.imooc.demo.entity;

/**
 * <p>标题: 价表管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-07-02 11:17
 */
public enum ActionType {
    INSERT("添加", 1),

    UPDATE("更新", 2),

    DELETE("删除", 3);

    private String name;

    private int index;

    ActionType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.getIndex() == index) {
                return actionType.name;
            }
        }
        return null;
    }

    public static Integer getIndex(String name) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.getName().equals(name)) {
                return actionType.index;
            }
        }
        return null;
    }

    public static ActionType getActionType(int index) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.getIndex() == index) {
                return actionType;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
