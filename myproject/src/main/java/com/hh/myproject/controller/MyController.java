package com.hh.myproject.controller;

import com.hh.myproject.dao.TestDao;
import com.hh.myproject.service.TestService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hejiayuan
 * @date 2020-09-21 11:38
 */

@RestController
@RequestMapping("/a")
@AllArgsConstructor
public class MyController {

    //@Autowired  省略这个注解  如果只有一个有构造器的情况下  或者 使用@AllArgsConstructor
    private final TestDao testDao;

    private final TestService testService;


//    public MyController(TestDao testDao){
//        this.testDao = testDao;
//    }

    @RequestMapping("/getInfo")
    public String getInfo(@RequestParam String id) {

        return testService.get(Integer.parseInt(id));
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        System.out.println("定时任务");
    }

}
