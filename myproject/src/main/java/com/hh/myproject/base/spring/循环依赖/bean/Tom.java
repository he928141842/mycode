package com.hh.myproject.base.spring.循环依赖.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author hejiayuan
 * @create 2021-07-29-21:42
 */
@Component
public class Tom {
    @Autowired
    Person person;
}
