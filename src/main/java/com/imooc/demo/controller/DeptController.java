package com.imooc.demo.controller;

import com.imooc.demo.entity.DeptInfo;
import com.imooc.demo.entity.ResultModel;
import com.imooc.demo.service.DeptInfoService;
import com.imooc.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>标题: 科室信息管理控制层</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-27 11:15
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptInfoService deptInfoService;

    @GetMapping(value = "/index")
    public ResultModel hello() {
        return ResultUtil.success("不需要安全效验的方法，Hello SpringBoot!");
    }

    @RequestMapping("/common")
    public String commonAccess(){
        return "only login can view";
    }

    @GetMapping(value = "/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResultModel admin() {
        return ResultUtil.success("only admin can access");
    }

    @GetMapping(value = "/listDeptInfo")
    public ResultModel<DeptInfo> listDeptInfo() {
        return ResultUtil.success(deptInfoService.queryDeptInfo());
    }

    @GetMapping(value = "/getDeptInfoByCode")
    public ResultModel<DeptInfo> getDeptInfoByCode(String deptCode){
        return ResultUtil.success(deptInfoService.queryDeptInfoById(deptCode));
    }
}
