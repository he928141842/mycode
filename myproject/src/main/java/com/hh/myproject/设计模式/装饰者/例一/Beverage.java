package com.hh.myproject.设计模式.装饰者.例一;

/**
 * 饮料抽象类
 * @author hejiayuan
 * @date 2021-06-16 15:36
 */
public abstract class Beverage {
    protected String desc = "还是一团浆糊";

    public abstract double cost();

    public String getDesc(){
        return desc;
    }
}
