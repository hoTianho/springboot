package com.imooc.demo.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import javax.sql.DataSource;
/**
 * <p>标题: 事务管理</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-06-26 15:20
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer{

    @Autowired
    private DataSource datasource;
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(datasource);
    }
}
