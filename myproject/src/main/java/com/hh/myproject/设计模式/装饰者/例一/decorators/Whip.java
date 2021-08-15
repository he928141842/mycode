package com.hh.myproject.设计模式.装饰者.例一.decorators;

import com.hh.myproject.设计模式.装饰者.例一.Beverage;
import com.hh.myproject.设计模式.装饰者.例一.CondimentDecorator;

/**
 * @author hejiayuan
 * @date 2021-06-16 16:05
 */
public class Whip extends CondimentDecorator {
    private Beverage beverage;

    private double price = 10.5;

    private String desc = "奶泡";

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + price;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + "," + desc;
    }
}
