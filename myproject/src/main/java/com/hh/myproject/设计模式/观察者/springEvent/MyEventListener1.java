package com.hh.myproject.设计模式.观察者.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author hejiayuan
 * @date 2021-04-28 16:13
 */
@Component
//实现观察者接口  注意范型必须是 ApplicationEvent的子类
public class MyEventListener1 implements ApplicationListener<MyEvent> {


    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.print("MyEventListener1++");
        //获取了被观察者（事件对象后） 调用它的方法（和观察者模式不同的是，不是数据发生改变 而是在观察者中执行业务逻辑？？）
        event.disPlay();
    }
}
