package com.imooc.demo.service.impl;

import com.imooc.demo.config.ApplicationContextHolder;
import com.imooc.demo.dao.DeptInfoDao;
import com.imooc.demo.entity.DeptInfo;
import com.imooc.demo.service.DeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>标题: 科室字典服务实现层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-27 11:11
 */
@Service
public class DeptInfoServiceImpl implements DeptInfoService {
    @Autowired
    private DeptInfoDao deptInfoDao;

    @Override
    public List<DeptInfo> queryDeptInfo() {
        return deptInfoDao.queryDeptInfo();
    }

    @Override
    public DeptInfo queryDeptInfoById(String deptCode) {
        return deptInfoDao.queryDeptInfoById(deptCode);
    }

    @Cacheable(cacheNames = {"menu"})
    @Override
    public List<String> testCache() {
        System.out.println("");
        System.out.println("mock:get from db");
        return Arrays.asList("article","comment","admin");
    }

    @Override
    public List<String> testMehodCache() {
        //以下方式相当于 this.testCache()
        //this没有走aop代理的bean，所以会导致不走缓存
//        return testCache();

        //处理方案如下
        DeptInfoServiceImpl proxy = ApplicationContextHolder.getContext().getBean(DeptInfoServiceImpl.class);
        return proxy.testCache();
    }
}
