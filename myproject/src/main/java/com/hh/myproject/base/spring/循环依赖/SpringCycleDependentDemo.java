package com.hh.myproject.base.spring.循环依赖;

import com.hh.myproject.base.spring.config.MainConfigOfAOP;
import com.hh.myproject.base.spring.循环依赖.config.DependenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 测试循环依赖
 * @author hejiayuan
 * @create 2021-07-29-21:44
 */
public class SpringCycleDependentDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(DependenceConfig.class);


    }
}
