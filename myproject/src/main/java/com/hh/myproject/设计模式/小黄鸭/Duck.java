package com.hh.myproject.设计模式.小黄鸭;

import com.hh.myproject.设计模式.小黄鸭.behavior.FlyBehavior;
import com.hh.myproject.设计模式.小黄鸭.behavior.QuackBehavior;

/**
 * @author hejiayuan
 * @date 2021-04-22 16:44
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
}
