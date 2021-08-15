package com.hh.myproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyprojectApplication {

    /**
     * springbootd的启动流程：
     *  1、首先创建一个springApplication并且保存一些信息，比较重要的是
     *      从各个jar包中的spring.factories中找到ApplicationInitializer 类以及 ApplicationListener并保存
     *  2、运行springApplication
     *      启动一个StopWatch 记录启动时间
     *      从所有spring.factories中找出SpringApplicationRunListener并且运行他的start方法 其中有各种Springapplication运行状态的监控方法
     *      准备一些ApplicationArguments
     *      准备环境，并且调用listeners的environmentPrepared方法 通知观察者们
     *      创建springioc容器
     *      准备ioc容器的的基本信息 其中也调用了各种监听器的通知方法
     *      刷新ioc容器  刷新完成后调用SpringrunApplicationListener的stated方法通知观察者
     *      从ioc容器中获取（不是从文件了）所有的ApplicationRunner  CommondLineRunner 并且执行
     *      调用所有listener的running方法 并且如果failed调用failed方法
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MyprojectApplication.class, args);
    }

}
