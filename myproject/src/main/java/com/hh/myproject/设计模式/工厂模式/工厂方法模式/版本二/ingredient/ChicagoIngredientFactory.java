package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.IngredientFactory;

/**
 * @author hejiayuan
 * @date 2021-06-23 17:36
 */
public class ChicagoIngredientFactory implements IngredientFactory {
    @Override
    public Dough createDough() {
        Dough dough = new Dough();
        dough.setName("芝加哥专用得面团");
        return dough;
    }

    @Override
    public Sauce createSauce() {
        Sauce sauce = new Sauce();
        sauce.setName("芝加哥专用得酱料");
        return sauce;
    }
}
