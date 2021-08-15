package com.hh.myproject.设计模式.观察者.springEvent2;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author hejiayuan
 * @date 2021-04-29 16:52
 */
@Component
public class UserListener implements ApplicationListener<UserEvent> {


    @Async//异步执行
    @Override
    public void onApplicationEvent(UserEvent event) {
        User2 user2 = event.getUser2();

        System.out.println(user2.toString()+"给积分");
    }

    @EventListener
    @Async
    public void onApplicationEvent2(UserEvent event){
        User2 user2 = event.getUser2();
        System.out.println(user2.toString()+"发邮件");
    }

}
