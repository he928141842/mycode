package com.hh.myproject.设计模式.装饰者.例一.decorators;

import com.hh.myproject.设计模式.装饰者.例一.Beverage;
import com.hh.myproject.设计模式.装饰者.例一.CondimentDecorator;

/**
 * 调料类
 * @author hejiayuan
 * @date 2021-06-16 15:53
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    private double price = 5.5;

    private String desc = "摩卡";

    //构造方法必须有个 饮料类
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + price;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ","+desc;
    }
}
