package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.芝加哥披萨相关;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.FactoryMethodPizza;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.FactoryMethodPizzaStore;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一.芝加哥披萨相关.pizzas.ChicagoCheeseStylePizza;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:35
 */
public class ChicagoPizzaStore extends FactoryMethodPizzaStore {
    @Override
    public FactoryMethodPizza createPizza(String type) {
        FactoryMethodPizza pizza = null;
        if ("cheese".equals(type)){
            pizza = new ChicagoCheeseStylePizza();
        }

        return pizza;
    }
}
