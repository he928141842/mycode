package com.hh.myproject.设计模式.复合模式;

import com.hh.myproject.设计模式.复合模式.观察者.QuackObserverble;

/** 1、首先创建一个Quackable接口
 *  鸭子将实现此接口，这样就知道哪些东西可以叫
 *
 *  继承这个QuackObserverble  6.0添加
 * @author hejiayuan
 * @create 2021-07-21-19:31
 */
public interface Quackable extends QuackObserverble {
    public void quack();
}
