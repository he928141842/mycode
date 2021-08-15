package com.hh.myproject.设计模式.小黄鸭.behavior;

/**
 * @author hejiayuan
 * @date 2021-04-22 16:44
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("鸭子在飞");
    }
}
