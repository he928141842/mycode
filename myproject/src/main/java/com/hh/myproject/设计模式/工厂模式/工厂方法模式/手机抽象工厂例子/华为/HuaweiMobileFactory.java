package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.华为;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Charger;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.MobileFactory;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Phone;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:34
 */
public class HuaweiMobileFactory implements MobileFactory {
    @Override
    public Phone CreatPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Charger CreatCharger() {
        return new HuaweiCharger();
    }
}
