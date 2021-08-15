package com.hh.myproject.设计模式.适配器模式以及外观模式.适配器;

/**
 * @author hejiayuan
 * @create 2021-07-18-16:57
 */
public class Turkey implements Turkey2{

    @Override
    public void turkeyGobble() {
        System.out.println("火鸡叫");
    }

    @Override
    public void turkeyFly() {
        System.out.println("火鸡飞10米");
    }
}
