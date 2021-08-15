package com.hh.myproject.设计模式.观察者.springEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author hejiayuan
 * @date 2021-04-28 16:10
 */
@Component
public class MyEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(ApplicationContext source) {
        super(source);
        System.out.println("事件构造方法执行。。。");
    }

    public void disPlay(){
        System.out.println("事件具体业务逻辑执行。。。。");
    }

}
