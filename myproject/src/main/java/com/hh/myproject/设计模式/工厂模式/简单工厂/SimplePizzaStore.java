package com.hh.myproject.设计模式.工厂模式.简单工厂;

import com.hh.myproject.设计模式.工厂模式.简单工厂.simpleFactory.SimplePizzaFactory;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:31
 */
public class SimplePizzaStore {
    SimplePizzaFactory simplePizzaFactory;

    public SimplePizzaStore(SimplePizzaFactory simplePizzaFactory){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public SimplePizza orderPizza(String type){
        SimplePizza pizza;
        //使用简单工厂  来达到对修改关闭
        pizza = simplePizzaFactory.creatPizza(type);

        pizza.prepared();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;

    }

    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        SimplePizzaStore simplePizzaStore = new SimplePizzaStore(simplePizzaFactory);
        simplePizzaStore.orderPizza("cheese");

        /**
         * 如果纽约得披萨店 和 德州得披萨店 加盟店
         * 可能就是  NYSimplePizzaFacory nyStore = new NYSimplePizzaFacory();
         *  SimplePizzaStore simplePizzaStore = new SimplePizzaStore(nyStore);
         *  simplePizzaStore.orderPizza("cheese");
         *
         *  但是这样的话 制作披萨的流程是绑定在store中的 pizza.prepared();2.0用料可能不同（1.0中暂不考虑）
         *         pizza.bake(); 2.0烘烤可能不同
         *         pizza.cut(); 2.0 切片可能不同
         *         pizza.box();
         *        1.0 纽约得工做得披萨 可能和德州得不一样 这样就需要引入工厂方法  具体做法是将共同的
         *         比如处理订单得 流程 prepared  bake cut  box放在 统一得商店中去管理
         *         把不同的  创建不同地区口味pizza得方法 作为抽象得方法去由 纽约 德州。。去实现
         *
         */


    }

}
