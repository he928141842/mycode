package com.hh.myproject.设计模式.复合模式.观察者;

/**
 * 观察者对象只有一个方法 那就是update方法
 * 当被观察者做出了行动  观察者要调用这个方法
 * @author hejiayuan
 * @create 2021-07-21-21:01
 */
public interface DuckObserver {
    void update(QuackObserverble duck);
}
