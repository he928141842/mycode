package com.hh.myproject.设计模式.复合模式.抽象鸭子工厂;

import com.hh.myproject.设计模式.复合模式.Quackable;

/**
 * @author hejiayuan
 * @create 2021-07-21-20:00
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedHeadDuck();
    public abstract Quackable createDuckCallDuck();
}
