package com.hh.myproject.设计模式.复合模式.鸭子类;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.观察者.DuckObserver;
import com.hh.myproject.设计模式.复合模式.观察者.Observerble;

/** 绿头鸭
 * @author hejiayuan
 * @create 2021-07-21-19:33
 */
public class MallardDuck implements Quackable {
    String name;
    //使用这个来统一管理 6.0
    Observerble observerble;
    public MallardDuck() {
        //将这个被观察者放入 Observerble对象
        this.observerble = new Observerble(this);
        this.name = "我是绿头鸭";
    }

    @Override
    public void quack() {
        System.out.println("绿头鸭子在叫");
        notifyObservers();

    }

    @Override
    public void registerObserver(DuckObserver observer) {
        observerble.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observerble.notifyObservers();
    }
}
