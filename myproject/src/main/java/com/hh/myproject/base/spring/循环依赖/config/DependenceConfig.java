package com.hh.myproject.base.spring.循环依赖.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author hejiayuan
 * @create 2021-07-29-22:05
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.hh.myproject.base.spring.循环依赖.bean")
public class DependenceConfig {


}
