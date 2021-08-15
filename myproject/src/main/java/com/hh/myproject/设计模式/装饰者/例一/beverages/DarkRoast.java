package com.hh.myproject.设计模式.装饰者.例一.beverages;

import com.hh.myproject.设计模式.装饰者.例一.Beverage;

/**
 * @author hejiayuan
 * @date 2021-06-16 16:03
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        super.desc = "深度烘焙咖啡";
    }

    @Override
    public double cost() {
        return 30;
    }
}
