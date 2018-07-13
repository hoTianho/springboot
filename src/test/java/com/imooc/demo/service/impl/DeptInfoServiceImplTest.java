package com.imooc.demo.service.impl;

import com.imooc.demo.service.DeptInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@EnableCaching
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptInfoServiceImplTest {
    @Autowired
    private DeptInfoService deptInfoService;
    @Test
    public void queryDeptInfo() {
    }

    @Test
    public void queryDeptInfoById() {
    }

    @Test
    public void testCache() {
        System.out.println("call:" + deptInfoService.testCache());
        System.out.println("call:" + deptInfoService.testCache());
    }

    @Test
    public void testMethodCache() {
        //测试调用内部方法testCache，是否读取Cache的示例
        System.out.println("call:" + deptInfoService.testMehodCache());
        System.out.println("call:" + deptInfoService.testMehodCache());
    }
}