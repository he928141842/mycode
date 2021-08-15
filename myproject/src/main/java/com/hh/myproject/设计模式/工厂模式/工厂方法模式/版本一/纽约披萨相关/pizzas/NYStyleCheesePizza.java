package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.纽约披萨相关.pizzas;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.FactoryMethodPizza;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:27
 */
public class NYStyleCheesePizza extends FactoryMethodPizza {
    public NYStyleCheesePizza() {
        name = "纽约风味得奶酪披萨";
        dough = "薄脆版";
        sauce = "海天酱油";
        toppings.add("老干妈");
    }
}
