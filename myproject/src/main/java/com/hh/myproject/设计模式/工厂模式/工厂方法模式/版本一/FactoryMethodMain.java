package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.纽约披萨相关.NYPizzaStore;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.芝加哥披萨相关.ChicagoPizzaStore;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:42
 */
public class FactoryMethodMain {
    public static void main(String[] args) {

        FactoryMethodPizzaStore nypizzaStore = new NYPizzaStore();
        nypizzaStore.orderPizza("cheese");

        FactoryMethodPizzaStore chicagoStore = new ChicagoPizzaStore();
        chicagoStore.orderPizza("cheese");
    }
}
