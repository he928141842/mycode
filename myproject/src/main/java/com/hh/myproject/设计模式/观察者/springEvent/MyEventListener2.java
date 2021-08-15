package com.hh.myproject.设计模式.观察者.springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author hejiayuan
 * @date 2021-04-28 16:18
 */
@Component
public class MyEventListener2 {

    @EventListener
    public void onEvent(MyEvent myEvent){
        System.out.println("MyEventListener2+++");
        myEvent.disPlay();
    }

}
