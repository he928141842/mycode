package com.hh.myproject.设计模式.观察者.springEvent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hejiayuan
 * @date 2021-04-28 16:23
 */
@Component
public class MyEventPublisher implements ApplicationContextAware {
    private ApplicationContext applicationContext;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish(MyEvent myEvent){
        System.out.println("MyEventPublisher发布事件");
        applicationContext.publishEvent(myEvent);
    }

}
