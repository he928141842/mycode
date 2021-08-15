package com.hh.myproject.设计模式.适配器模式以及外观模式.适配器;

/**
 * @author hejiayuan
 * @create 2021-07-18-16:59
 */
public class AdaptorMain {
    public static void main(String[] args) {
        /**
         * 适配器模式：将一个类的接口，转换成客户期望的另一个接口，让原本接口不兼容的类可以配合工作
         *  JDK中的Enumeration和Iterator接口就是
         *  Enumeration是比较老的接口，Iterator是新的，但是有些老代码需要使用Enumeration
         *  就可以通过EnumerationIterator去实现适配
         *
         * 假设缺鸭子对象 现在想将火鸡拿来用 就需要适配火鸡
         *
         *
         * 装饰者模式：不改变接口，但是加入新的行为和责任
         * 适配器模式：将一个接口转换成另一个接口
         * 外观模式：让接口更简单
         *
         * spring中的advisor
         * springmvc中的dodispatch 通过handlerAdapter去匹配对应的controller
         *
         *
         */
        ToilDuck toilDuck = new ToilDuck();
        toilDuck.gobble();
        toilDuck.fly();

        Turkey2 turkey = new Turkey();
        Duck2 duckAdaptor = new DuckAdaptor(turkey);

        duckAdaptor.gobble();
        duckAdaptor.fly();

    }
}
