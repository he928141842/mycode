package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:55
 */
public abstract class FactoryMethodPizzaStore3 {

    public FactoryMethodPizza3 orderPizza(String type){
        FactoryMethodPizza3 pizz ;
        pizz = createPizza(type);

        pizz.prepared();
        pizz.bake();
        pizz.cut();
        pizz.box();

        return pizz;
    }

    /**
     * 此方法 就是工厂方法
     * 当orderPizza调用时 某个披萨店子类将决定创建哪一种披萨
     * 子类不是实时决定（理解为不是你创建的时候才选择创建纽约风味得还是德州风味得  而是从你进去哪一家店
     * 也就是实例化哪一个加盟店就决定好了  由顾客决定）
     *
     *  重要****
     *  在设计模式中，所谓得实现一个接口，并不一定表示写一个类，然后通过implements
     *  关键字来实现一个java接口，实现一个接口泛指实现某个超类型（可以是类或接口）
     *  得某个方法
     *
     */
    protected abstract FactoryMethodPizza3 createPizza(String type);

}
