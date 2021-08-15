package com.hh.myproject.service;

import com.hh.myproject.bean.People;
import com.hh.myproject.bean.User;

/**
 * @author hejiayuan
 * @date 2020-11-20 9:04
 */
public interface TestService {

    String get(int id);

    int insert(People people);

    void testTransactional();

    static void default2method(){
        System.out.println("调用默认的方法2");
    }
    default void deafaultMethod(){
        System.out.println("调用默认的方法");
    }
}
