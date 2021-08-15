package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.纽约披萨相关.NYPizzaStore2;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.芝加哥披萨相关.ChicagoPizzaStore2;

/**
 * @author hejiayuan
 * @date 2021-06-23 15:42
 */
public class FactoryMethodMain2 {
    public static void main(String[] args) {
        /**
         * 在加入的原料IngredientFactory中使用到了 抽象工厂模式
         * 抽象工厂模式提供了一个接口，用来创建相关或者依赖对象的家族，而不需要指明具体类型
         * （他是属于同一个家族的产品的抽象工厂  Dough Sauce 等都属于原料）
         */


        FactoryMethodPizzaStore2 nypizzaStore = new NYPizzaStore2();
        nypizzaStore.orderPizza("cheese");

        FactoryMethodPizzaStore2 chicagoStore = new ChicagoPizzaStore2();
        chicagoStore.orderPizza("cheese");
    }
}
