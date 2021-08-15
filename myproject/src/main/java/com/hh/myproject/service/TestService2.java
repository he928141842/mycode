package com.hh.myproject.service;

import com.hh.myproject.bean.People;

/**
 * @author hejiayuan
 * @date 2020-11-20 9:04
 */
public interface TestService2 {

    String get(int id);

    int insert(People people);

    void testTransactional();
}
