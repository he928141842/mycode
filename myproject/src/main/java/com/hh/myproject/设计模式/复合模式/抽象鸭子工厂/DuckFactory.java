package com.hh.myproject.设计模式.复合模式.抽象鸭子工厂;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.鸭子类.DuckCall;
import com.hh.myproject.设计模式.复合模式.鸭子类.MallardDuck;
import com.hh.myproject.设计模式.复合模式.鸭子类.RedHeadDuck;

/**这个工厂创建的是没有被装饰过的鸭子类
 * @author hejiayuan
 * @create 2021-07-21-20:01
 */
public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createDuckCallDuck() {
        return new DuckCall();
    }
}
