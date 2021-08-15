package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂;

/**
 * @author hejiayuan
 * @create 2021-07-15-17:16
 */
public class AbstractFactoryMain {
    /**
     * 与工厂方法不同点在于 他是创建同一个产品系列的工厂  工厂方法只是创建同一个产品 交由子类去实现
     * 抽象工厂中也用到了工厂方法
     *  根据版本2而来
     *  IngredientFactory3 就是抽象工厂方法 定义了一个产品组 后期扩展比较方便
     *  而其中的Dough3  使用到了工厂方法 作为其中的具体的产品等级这个不能轻易改变
     *
     */
    public static void main(String[] args) {

    }

}
