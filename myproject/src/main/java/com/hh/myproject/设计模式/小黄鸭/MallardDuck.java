package com.hh.myproject.设计模式.小黄鸭;

import com.hh.myproject.设计模式.小黄鸭.behavior.FlyWithWings;
import com.hh.myproject.设计模式.小黄鸭.behavior.Quack;

/**
 * 绿头鸭
 * @author hejiayuan
 * @date 2021-04-22 16:37
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("Im a real Mallard duck");
    }
}
