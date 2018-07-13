package com.imooc.demo.service.impl;

import com.imooc.demo.dao.BaseDictDao;
import com.imooc.demo.entity.BaseDict;
import com.imooc.demo.enums.ResultEnum;
import com.imooc.demo.exception.DictException;
import com.imooc.demo.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>标题: 基本字典服务实现层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 15:26
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> queryBaseDict() {
        //测试返回自定义错误示例
//        if (1 > 0) {
//            throw new DictException(ResultEnum.ERROE);
//        }
        return baseDictDao.queryBaseDict();
    }

    @Override
    public List<BaseDict> queryBaseDictById(String dictName) {
        return baseDictDao.queryBaseDictById(dictName);
    }
}
