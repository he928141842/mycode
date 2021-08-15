package com.hh.myproject.设计模式.小黄鸭.behavior;

/**
 * @author hejiayuan
 * @date 2021-04-25 16:38
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("im flying with a rocket!");
    }
}
