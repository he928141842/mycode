package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.纽约披萨相关;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.FactoryMethodPizza3;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.FactoryMethodPizzaStore3;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.ingredient.NYIngredientFactory3;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.纽约披萨相关.pizzas.NYStyleCheesePizza3;


/**
 * @author hejiayuan
 * @date 2021-06-23 15:28
 */
public class NYPizzaStore3 extends FactoryMethodPizzaStore3 {

    @Override
    protected FactoryMethodPizza3 createPizza(String type) {
        FactoryMethodPizza3 pizza = null;
        NYIngredientFactory3 nyIngredientFactory3 = new NYIngredientFactory3();

        if ("cheese".equals(type)){
            pizza = new NYStyleCheesePizza3(nyIngredientFactory3);
        }

        return pizza;
    }
}
