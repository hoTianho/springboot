package com.imooc.demo.entity;

import java.util.Date;

/**
 * <p>标题: 科室字典</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-27 11:02
 */
public class DeptInfo {
    private String deptCode;

    private String deptName;

    private Integer sortNo;

    private Date creatorTime;

    private String creatorCode;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", sortNo=" + sortNo +
                ", creatorTime=" + creatorTime +
                ", creatorCode='" + creatorCode + '\'' +
                '}';
    }
}
