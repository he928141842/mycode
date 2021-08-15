package com.hh.myproject.设计模式.观察者.springEvent2;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hejiayuan
 * @date 2021-04-29 17:00
 */
@RestController
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController {
    @Resource
    private ApplicationEventPublisher publisher;


    @PostMapping(value = "/addUser")
    public User2 addUser(@RequestBody User2 user){
        String username = user.getUsername();
        //发布任务
        publisher.publishEvent(new UserEvent(user));
        return user;

    }

}
