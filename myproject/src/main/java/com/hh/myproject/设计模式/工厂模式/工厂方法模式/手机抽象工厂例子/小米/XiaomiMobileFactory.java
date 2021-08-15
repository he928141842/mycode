package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.小米;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Charger;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.MobileFactory;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Phone;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:34
 */
public class XiaomiMobileFactory implements MobileFactory {
    @Override
    public Phone CreatPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Charger CreatCharger() {
        return new XIaomiCharger();
    }
}
