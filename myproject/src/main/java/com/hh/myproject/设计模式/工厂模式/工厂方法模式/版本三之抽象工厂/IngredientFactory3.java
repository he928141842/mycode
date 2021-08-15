package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.ingredient.Dough3;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.ingredient.Sauce3;

/**
 *
 * 抽象工厂模式  族
 * @author hejiayuan
 * @date 2021-06-23 17:29
 */
public interface IngredientFactory3 {

     Dough3 createDough();
     Sauce3 createSauce();
}
