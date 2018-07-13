package com.imooc.demo.entity;

/**
 * <p>标题: 修改项内容</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-07-02 11:39
 */
public class ChangeItem {
    /**
     * 字段名称
     */
    private String field;
    /**
     * 字段中文名称
     */
    private String fieldShowName;
    /**
     * 字段旧值
     */
    private String oldValue;
    /**
     * 字段新值
     */
    private String newValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldShowName() {
        return fieldShowName;
    }

    public void setFieldShowName(String fieldShowName) {
        this.fieldShowName = fieldShowName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
