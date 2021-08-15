package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient.Dough;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient.Sauce;

/**
 *
 * 抽象工厂模式  族
 * @author hejiayuan
 * @date 2021-06-23 17:29
 */
public interface IngredientFactory {
     //Dough 通常写成接口？
     Dough createDough();

     Sauce createSauce();
}
