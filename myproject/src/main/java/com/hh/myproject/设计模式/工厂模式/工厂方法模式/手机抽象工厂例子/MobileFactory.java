package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子;

/**
 * 抽象工厂   产品族
 * @author hejiayuan
 * @create 2021-07-16-11:30
 */
public interface MobileFactory {
    Phone CreatPhone();
    Charger CreatCharger();
}
