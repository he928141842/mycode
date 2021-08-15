package com.hh.myproject.设计模式.小黄鸭;

import com.hh.myproject.设计模式.小黄鸭.behavior.FlyNoway;
import com.hh.myproject.设计模式.小黄鸭.behavior.Quack;

/**
 * 模型鸭 不会飞
 * @author hejiayuan
 * @date 2021-04-22 17:45
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoway();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("I’m a model duck");
    }
}
