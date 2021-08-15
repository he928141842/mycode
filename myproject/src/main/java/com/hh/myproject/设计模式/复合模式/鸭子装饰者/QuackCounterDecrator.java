package com.hh.myproject.设计模式.复合模式.鸭子装饰者;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.观察者.DuckObserver;

/**
 * 鸭子计数装饰者 需要跟被装饰者同属 所以也实现Quackable接口
 * @author hejiayuan
 * @create 2021-07-21-19:48
 */
public class QuackCounterDecrator implements Quackable {
    public static int NUM_OF_QUACK;
    //被装饰者 通过组合的方式关联
    //由于这个具体鸭子类中已经有个6.0的观察者有关的创建 所以这里直接调用regist方法
    Quackable duck;


    public QuackCounterDecrator(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        NUM_OF_QUACK += 1;
    }

    public static int getNumOfQuack(){
        return NUM_OF_QUACK;
    }

    @Override
    public void registerObserver(DuckObserver observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
