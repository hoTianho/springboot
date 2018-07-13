package com.imooc.demo.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * <p>标题: 用户管理</p>
 * <p>描述: </p>
 * <p>版权: Copyright (c) 2018</p>
 * <p>公司: 智业软件股份有限公司</p>
 *
 * @author Administrator
 * @date 2018-07-02 9:14
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/index","/dept/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    protected  void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("demo").password(
                        new BCryptPasswordEncoder().encode("demo")).roles("USER")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(
                new BCryptPasswordEncoder().encode("admin")).roles("ADMIN");
    }
}
