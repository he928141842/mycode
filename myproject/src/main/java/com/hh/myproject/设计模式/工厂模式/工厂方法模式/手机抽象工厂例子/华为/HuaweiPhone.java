package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.华为;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Phone;


public class HuaweiPhone extends Phone {
    public HuaweiPhone() {
        this.name = "华为手机";
    }

    @Override
    public Phone creatPhone() {

        return new HuaweiPhone();
    }
}
