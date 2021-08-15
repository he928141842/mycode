package com.hh.myproject.service;

import com.hh.myproject.bean.People;
import com.hh.myproject.bean.User;
import com.hh.myproject.dao.TestDao;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author hejiayuan
 * @date 2020-11-20 9:02
 */
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    TestDao testDao;
    @Autowired
    TestService testService;

    @Override
    @Cacheable(value = "pp")
    public String get(int id){
        System.out.println("进来方法了");
        return testDao.getInfo(id);
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int insert(People people) {
        int insert = testDao.insert(people);
        if (Objects.equals("10",people.getId())){
            throw new RuntimeException("第十位插入出错");
        }
        return insert;
    }

    @Transactional
    @Override
    public void testTransactional() {
        List<People> peoples = Arrays.asList(new People("1", "tom"), new People("2", "tom2"), new People("3", "tom3"),
                new People("4", "tom4"), new People("5", "tom5"), new People("6", "tom6"),
                new People("7", "tom7"), new People("8", "tom8"), new People("9", "tom9"),
                new People("10", "tom10"));
        peoples.forEach(people -> {
            TestServiceImpl proxy = (TestServiceImpl) AopContext.currentProxy();
            //int insert = proxy.insert(people);
            int insert = insert(people);
        });

        int a = 1/0;

    }


}
