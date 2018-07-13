package com.imooc.demo.controller;

import com.imooc.demo.entity.BaseDict;
import com.imooc.demo.entity.ResultModel;
import com.imooc.demo.service.BaseDictService;
import com.imooc.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>标题: 价表管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 10:27
 */

@RestController
@RequestMapping("/hello")
public class HelloControl {
    @Autowired
    private BaseDictService baseDictService;

    @GetMapping(value = "/hello")
    public ResultModel Hello() {
        return null;
//        return ResultUtil.success("Hello SpringBoot!");
    }

    @GetMapping(value = "/listBaseDict")
    public ResultModel<BaseDict> listBaseDict() {
        List<BaseDict> baseDictList = baseDictService.queryBaseDict();
        return ResultUtil.success(baseDictList);
    }

    @GetMapping(value = "/getBaseDictByDictName")
    public ResultModel<BaseDict> getBaseDictByDictName(String dictName) {
        int a = 1/0;
        List<BaseDict> baseDictList = baseDictService.queryBaseDictById(dictName);
        return ResultUtil.success(baseDictList);
    }
}
