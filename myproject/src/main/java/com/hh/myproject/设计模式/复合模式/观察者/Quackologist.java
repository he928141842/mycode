package com.hh.myproject.设计模式.复合模式.观察者;

/**
 * 具体的观察者 鸭子观察者
 * @author hejiayuan
 * @create 2021-07-21-21:21
 */
public class Quackologist implements DuckObserver{
    @Override
    public void update(QuackObserverble duck) {
        System.out.println("Quackologist"+duck+"刚刚被我看到叫了");
    }
}
