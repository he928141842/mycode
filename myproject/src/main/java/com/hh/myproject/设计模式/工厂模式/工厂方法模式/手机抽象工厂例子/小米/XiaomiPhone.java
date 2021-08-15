package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.小米;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.Phone;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:36
 */
public class XiaomiPhone extends Phone {
    public XiaomiPhone() {
        this.name = "小米手机";
    }

    @Override
    public Phone creatPhone() {

        return new XiaomiPhone();
    }
}
