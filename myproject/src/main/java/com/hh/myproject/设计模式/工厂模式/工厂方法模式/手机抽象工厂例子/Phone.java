package com.hh.myproject.设计模式.工厂模式.工厂方法模式.手机抽象工厂例子;

/**
 * @author hejiayuan
 * @create 2021-07-16-11:31
 */
public abstract class Phone {
    public String name;
    public void inCalling(){
        Phone phone = creatPhone();
        System.out.println(phone.name+"：正在打电话。。");
    }

    public abstract Phone creatPhone();
}
