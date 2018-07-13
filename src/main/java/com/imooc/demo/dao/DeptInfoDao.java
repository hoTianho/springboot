package com.imooc.demo.dao;

import com.imooc.demo.entity.DeptInfo;

import java.util.List;

public interface DeptInfoDao {

    /**
     * 获取所有科室信息
     * @return
     */
    List<DeptInfo> queryDeptInfo();

    /**
     * 获取指定科室信息
     * @param deptCode
     * @return
     */
    DeptInfo queryDeptInfoById(String deptCode);
}
