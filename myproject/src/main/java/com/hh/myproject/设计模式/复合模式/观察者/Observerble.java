package com.hh.myproject.设计模式.复合模式.观察者;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 由于鸭子实现的Quackble继承了QuackObserverble接口
 * 所以采用组合模式  这个类相当于聚合类实现
 * @author hejiayuan
 * @create 2021-07-21-21:08
 */
public class Observerble implements QuackObserverble{
    List<DuckObserver> observers = new ArrayList<>();
    QuackObserverble duck;

    public Observerble(QuackObserverble duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(DuckObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<DuckObserver> iterator = observers.iterator();
        while (iterator.hasNext()) {
            DuckObserver next = iterator.next();
            next.update(duck);
        }
    }
}
