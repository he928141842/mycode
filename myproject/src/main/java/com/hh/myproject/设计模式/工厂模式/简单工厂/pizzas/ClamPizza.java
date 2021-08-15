package com.hh.myproject.设计模式.工厂模式.简单工厂.pizzas;

import com.hh.myproject.设计模式.工厂模式.简单工厂.SimplePizza;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:19
 */
public class ClamPizza extends SimplePizza {

    public ClamPizza() {
        this.name = "蛤蜊披萨";
    }

    @Override
    public void prepared() {
        System.out.println("蛤蜊披萨正在准备。。。");
    }

    @Override
    public void bake() {
        System.out.println("正在烘烤。。。");
    }

    @Override
    public void cut() {
        System.out.println("正在切块。。。");
    }

    @Override
    public void box() {
        System.out.println("蛤蜊披萨正在打包。。。");
    }
}
