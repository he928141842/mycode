package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.小米;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Charger;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:37
 */
public class XIaomiCharger extends Charger {
    public XIaomiCharger() {
        this.name = "小米充电器";
    }

    @Override
    public Charger creatCharger() {

        return new XIaomiCharger();
    }
}
