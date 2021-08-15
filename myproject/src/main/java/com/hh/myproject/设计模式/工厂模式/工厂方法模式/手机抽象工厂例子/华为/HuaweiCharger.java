package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.华为;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Charger;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:37
 */
public class HuaweiCharger extends Charger {
    public HuaweiCharger() {
        this.name = "华为充电器";
    }

    @Override
    public Charger creatCharger() {
        return new HuaweiCharger();
    }
}
