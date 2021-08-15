package com.hh.myproject.设计模式.工厂模式.简单工厂;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:15
 */
public abstract class SimplePizza {

    public String name;


    public abstract void prepared();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();


}
