package com.imooc.demo.service;

import com.imooc.demo.entity.BaseDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDictService {
    /**
     * 列出 所有字典信息
     * @return
     */
    List<BaseDict> queryBaseDict();

    /**
     * 根据字典名称列出字典信息
     * @param dictName
     * @return
     */
    List<BaseDict> queryBaseDictById(String dictName);
}
