package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.ingredient;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.IngredientFactory3;

/**
 * @author hejiayuan
 * @date 2021-06-23 17:36
 */
public class ChicagoIngredientFactory3 implements IngredientFactory3 {
    @Override
    public Dough3 createDough() {
        return new RedDough();
    }

    @Override
    public Sauce3 createSauce() {
        return new ChicagoSauce3();
    }


}
