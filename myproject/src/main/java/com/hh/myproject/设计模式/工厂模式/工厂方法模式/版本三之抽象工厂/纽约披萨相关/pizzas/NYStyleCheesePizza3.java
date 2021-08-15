package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.纽约披萨相关.pizzas;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.FactoryMethodPizza3;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.IngredientFactory3;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:27
 */
public class NYStyleCheesePizza3 extends FactoryMethodPizza3 {

    IngredientFactory3 ingredientFactory3;

    public NYStyleCheesePizza3(IngredientFactory3 ingredientFactory3) {
        this.ingredientFactory3 = ingredientFactory3;
        name = "纽约风味得芝士披萨";
    }

    @Override
    protected void prepared() {

        dough = ingredientFactory3.createDough();
        sauce = ingredientFactory3.createSauce();
        System.out.println("正在准备。。。"+name);
        System.out.println("用的面团。。。"+dough.getName());
        System.out.println("用的酱料。。。"+sauce.getName());
    }
}
