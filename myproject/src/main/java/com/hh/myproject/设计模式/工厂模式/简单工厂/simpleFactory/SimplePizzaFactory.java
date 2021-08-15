package com.hh.myproject.设计模式.工厂模式.简单工厂.simpleFactory;

import com.hh.myproject.设计模式.工厂模式.简单工厂.SimplePizza;
import com.hh.myproject.设计模式.工厂模式.简单工厂.pizzas.CheesePizza;
import com.hh.myproject.设计模式.工厂模式.简单工厂.pizzas.ClamPizza;
import com.hh.myproject.设计模式.工厂模式.简单工厂.pizzas.VeggiePizza;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:26
 */
public class SimplePizzaFactory {

    //静态方法来作为简单工厂更加常见 比如单例模式  但是不能通过继承来重写
    public  SimplePizza creatPizza(String type){
        SimplePizza pizza = null;

        if ("cheese".equals(type)){
            pizza = new CheesePizza();
        }else if ("clam".equals(type)){
            pizza = new ClamPizza();
        }else if ("veggie".equals(type)){
            pizza = new VeggiePizza();
        }

        return pizza;
    }


}
