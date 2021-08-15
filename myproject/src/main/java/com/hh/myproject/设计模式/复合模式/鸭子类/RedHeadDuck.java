package com.hh.myproject.设计模式.复合模式.鸭子类;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.观察者.DuckObserver;
import com.hh.myproject.设计模式.复合模式.观察者.Observerble;

/**
 * @author hejiayuan
 * @create 2021-07-21-19:35
 */
public class RedHeadDuck implements Quackable {
    String name;
    Observerble observerble;
    public RedHeadDuck() {
        this.observerble = new Observerble(this);
        this.name = "我是红头鸭";
    }

    @Override
    public void quack() {
        System.out.println("红头鸭子在叫");
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
