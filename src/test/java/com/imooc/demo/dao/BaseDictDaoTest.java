package com.imooc.demo.dao;

import com.imooc.demo.entity.BaseDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseDictDaoTest {
    @Autowired
    private BaseDictDao baseDictDao;

    @Test
    public void queryBaseDict() {
        List<BaseDict> baseDictList = baseDictDao.queryBaseDict();
        assertEquals(3991, baseDictList.size());
    }

    @Test
    public void queryBaseDictById() {
        List<BaseDict> baseDictList = baseDictDao.queryBaseDictById("ADMISSION_PURPOSE");
        assertEquals(4, baseDictList.size());
    }
}