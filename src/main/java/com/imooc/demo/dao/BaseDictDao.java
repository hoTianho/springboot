package com.imooc.demo.dao;

import com.imooc.demo.entity.BaseDict;

import java.util.List;

/**
 * <p>标题: 价表管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 14:05
 */
public interface BaseDictDao {
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
