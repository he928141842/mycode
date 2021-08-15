package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.芝加哥披萨相关;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.FactoryMethodPizza2;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.FactoryMethodPizzaStore2;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient.ChicagoIngredientFactory;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.芝加哥披萨相关.pizzas.ChicagoCheeseStylePizza2;


/**
 * @author hejiayuan
 * @date 2021-06-23 15:35
 */
public class ChicagoPizzaStore2  extends FactoryMethodPizzaStore2 {


    @Override
    protected FactoryMethodPizza2 createPizza(String type) {
        FactoryMethodPizza2 pizza = null;
        ChicagoIngredientFactory chicagoIngredientFactory = new ChicagoIngredientFactory();

        if ("cheese".equals(type)){
            pizza = new ChicagoCheeseStylePizza2(chicagoIngredientFactory);
        }

        return pizza;
    }
}
