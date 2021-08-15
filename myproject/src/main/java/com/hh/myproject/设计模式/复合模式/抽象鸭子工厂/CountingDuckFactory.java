package com.hh.myproject.设计模式.复合模式.抽象鸭子工厂;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.鸭子类.DuckCall;
import com.hh.myproject.设计模式.复合模式.鸭子类.MallardDuck;
import com.hh.myproject.设计模式.复合模式.鸭子类.RedHeadDuck;
import com.hh.myproject.设计模式.复合模式.鸭子装饰者.QuackCounterDecrator;

/**
 * 创建增加了计数行为的鸭子类
 * @author hejiayuan
 * @create 2021-07-21-20:03
 */
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounterDecrator(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounterDecrator(new RedHeadDuck());
    }

    @Override
    public Quackable createDuckCallDuck() {
        return new QuackCounterDecrator(new DuckCall());
    }
}
