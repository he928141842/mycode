package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.芝加哥披萨相关.pizzas;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.FactoryMethodPizza;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:35
 */
public class ChicagoCheeseStylePizza extends FactoryMethodPizza {
    public ChicagoCheeseStylePizza() {
        name = "芝加哥风味得奶酪披萨";
        dough = "加厚版";
        sauce = "老抽";
        toppings.add("老干爹");
    }
}
