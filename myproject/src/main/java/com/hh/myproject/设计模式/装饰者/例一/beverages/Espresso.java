package com.hh.myproject.设计模式.装饰者.例一.beverages;

import com.hh.myproject.设计模式.装饰者.例一.Beverage;

/**
 * 具体的饮料类
 * @author hejiayuan
 * @date 2021-06-16 15:55
 */
public class Espresso extends Beverage {

    public Espresso() {
        super.desc = "浓咖啡";
    }

    @Override
    public double cost() {
        return 20;
    }
}
