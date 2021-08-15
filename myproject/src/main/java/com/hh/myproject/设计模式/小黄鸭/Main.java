package com.hh.myproject.设计模式.小黄鸭;

import com.hh.myproject.设计模式.小黄鸭.behavior.FlyRocketPowered;

/** 策略模式？
 * @author hejiayuan
 * @date 2021-04-22 17:35
 */
public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        //1、如果在这里设定了  它的动作以后  不能动态的修改它的动作了  在duck类加上 setter方法
        duck.performFly();
        duck.performQuack();

        //2、可以根据具体的需求动态的修改它的行为
        Duck duck1 = new ModelDuck();
        duck1.performFly();
        duck1.setFlyBehavior(new FlyRocketPowered());
        duck1.performFly();

    }
}
