package com.imooc.demo.service;

import com.imooc.demo.entity.DeptInfo;

import java.util.List;

public interface DeptInfoService {
    /**
     * 列出所有科室信息
     * @return
     */
    List<DeptInfo> queryDeptInfo();

    /**
     * 获取指定科室代码的科室信息
     * @param deptCode
     * @return
     */
    DeptInfo queryDeptInfoById(String deptCode);

    List<String> testCache();

    List<String> testMehodCache();
}
