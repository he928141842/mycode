package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子;

/**
 * 充电器 实体类更适合用抽象类 行为类则使用接口
 * @author hejiayuan
 * @create 2021-07-16-11:31
 */
public abstract class Charger {
    public String name;

    public void inCharge(){
        Charger charger = creatCharger();
        System.out.println(charger.name+":正在充电");
    }

    public abstract Charger creatCharger();
}
