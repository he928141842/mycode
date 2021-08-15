package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.华为.HuaweiMobileFactory;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子.小米.XiaomiMobileFactory;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:42
 */
public class TestMain {
    public static void main(String[] args) {

        /**
         * 抽象工厂：产品族 和产品等级的概念
         *  充电器  移动设备 就是一个完整的手机产品族
         *  而具体的产品等级  就是小米手机  华为手机这个概念
         *  扩展产品等级很简单 但是要修改产品族的话代价较大
         */
        MobileFactory mobileFactory = new XiaomiMobileFactory();
        Charger charger = mobileFactory.CreatCharger();
        Phone phone = mobileFactory.CreatPhone();
        phone.inCalling();
        charger.inCharge();

        MobileFactory mobileFactory2 = new HuaweiMobileFactory();
        Charger charger2 = mobileFactory2.CreatCharger();
        Phone phone2 = mobileFactory2.CreatPhone();
        phone2.inCalling();
        charger2.inCharge();

    }
}
