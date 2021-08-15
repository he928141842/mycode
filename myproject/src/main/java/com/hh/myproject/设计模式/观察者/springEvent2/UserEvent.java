package com.hh.myproject.设计模式.观察者.springEvent2;

import org.springframework.context.ApplicationEvent;

/**
 * @author hejiayuan
 * @date 2021-04-29 16:48
 */
public class UserEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserEvent( Object source) {
        super(source);
    }

    public User2 getUser2(){
        if (source!=null){
            return (User2) source;
        }
        return null;
    }
}
