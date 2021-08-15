package com.hh.myproject.设计模式.适配器模式以及外观模式.适配器;

/**
 * @author hejiayuan
 * @create 2021-07-18-16:56
 */
public class ToilDuck implements Duck2{
    @Override
    public void gobble() {
        System.out.println("玩具鸭叫");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭飞了50米");
    }
}
