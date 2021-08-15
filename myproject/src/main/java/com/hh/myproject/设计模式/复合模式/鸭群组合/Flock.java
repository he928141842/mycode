package com.hh.myproject.设计模式.复合模式.鸭群组合;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.观察者.DuckObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 这是组合模式中的 聚合类实现  Quackable集合中可能是子节点 也就是具体鸭子类 和 Flock聚合类
 * @author hejiayuan
 * @create 2021-07-21-20:43
 */
public class Flock implements Quackable {
    //6.0因为实现了Quackable 并且Quackable是继承了QuackObserverble 所以Flock他也是一个QuackObserverble可被观察对象
    List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        //实际上这里用到了迭代器模式
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable next = iterator.next();
            next.quack();
        }
    }

    @Override
    public void registerObserver(DuckObserver observer) {
        //其实是群内的Quackable需要注册 这里看成是具体的鸭子
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable next = iterator.next();
            next.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {

    }
}
