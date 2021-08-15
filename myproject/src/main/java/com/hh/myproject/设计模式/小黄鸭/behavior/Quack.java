package com.hh.myproject.设计模式.小黄鸭.behavior;

/**
 * @author hejiayuan
 * @date 2021-04-22 16:43
 */
public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("鸭子在叫");
    }
}
