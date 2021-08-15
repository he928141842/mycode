package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.纽约披萨相关;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.FactoryMethodPizza2;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.FactoryMethodPizzaStore2;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient.NYIngredientFactory;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.纽约披萨相关.pizzas.NYStyleCheesePizza2;


/**
 * @author hejiayuan
 * @date 2021-06-23 15:28
 */
public class NYPizzaStore2 extends FactoryMethodPizzaStore2 {

    @Override
    protected FactoryMethodPizza2 createPizza(String type) {
        FactoryMethodPizza2 pizza = null;
        NYIngredientFactory nyIngredientFactory = new NYIngredientFactory();

        if ("cheese".equals(type)){
            pizza = new NYStyleCheesePizza2(nyIngredientFactory);
        }

        return pizza;
    }
}
