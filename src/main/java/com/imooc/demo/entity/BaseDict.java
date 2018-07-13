package com.imooc.demo.entity;

import java.util.Date;

/**
 * <p>标题: 基本字典</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 10:45
 */
public class BaseDict {
    private String dictName;

    private String valueCode;

    private String valueName;

    private Integer sortNo;

    private String validFlag;

    private String spellCode;

    private String wbzxCode;

    private String modifierCode;

    private Date modifiedTime;

    private String creatorCode;

    private Date createdTime;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getWbzxCode() {
        return wbzxCode;
    }

    public void setWbzxCode(String wbzxCode) {
        this.wbzxCode = wbzxCode;
    }

    public String getModifierCode() {
        return modifierCode;
    }

    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "dictName='" + dictName + '\'' +
                ", valueCode='" + valueCode + '\'' +
                ", valueName='" + valueName + '\'' +
                ", sortNo=" + sortNo +
                ", validFlag='" + validFlag + '\'' +
                ", spellCode='" + spellCode + '\'' +
                ", wbzxCode='" + wbzxCode + '\'' +
                ", modifierCode='" + modifierCode + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", creatorCode='" + creatorCode + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
