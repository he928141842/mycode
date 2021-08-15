package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.芝加哥披萨相关.pizzas;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.FactoryMethodPizza2;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.IngredientFactory;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:35
 */
public class ChicagoCheeseStylePizza2  extends FactoryMethodPizza2{
    IngredientFactory ingredientFactory;

    public ChicagoCheeseStylePizza2(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        name = "芝加哥风味奶酪披萨";
    }

    @Override
    protected void prepared() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        System.out.println("正在准备。。。"+name);
        System.out.println("用的面团。。。"+dough.getName());
        System.out.println("用的酱料。。。"+sauce.getName());
    }
}
