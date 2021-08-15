package com.hh.myproject.设计模式.观察者.springEvent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hejiayuan
 * @date 2021-04-28 16:27
 */
public class MyEventMain {
    @Autowired
    MyEvent myEvent;
    @Autowired
    MyEventPublisher myEventPublisher;



    public  void test() {
        myEventPublisher.publish(myEvent);
    }
}
