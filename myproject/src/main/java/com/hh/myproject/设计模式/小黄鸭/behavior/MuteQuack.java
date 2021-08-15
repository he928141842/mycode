package com.hh.myproject.设计模式.小黄鸭.behavior;

/**
 * @author hejiayuan
 * @date 2021-04-22 17:33
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("silence.....");
    }
}
