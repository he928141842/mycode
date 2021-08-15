package com.hh.myproject.设计模式.模板方法;

/**
 * @author hejiayuan
 * @create 2021-07-19-15:11
 */
public class TemplateMain {
    public static void main(String[] args) {
        /**
         * 喝咖啡和喝茶一共有四个流程
         *
         * 模板方法：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中去。
         *          可以使子类在不改变算法结构的前提下，重新定义算法中的某些步骤。
         *好莱坞原则：别调用我们，我们调用你。 允许底层组件将自己挂钩到系统上，但是高层次组件决定什么时候和怎么调用低层次组件
         *
         * 工厂方法是一种特殊的模板方法。
         * 策略模式：封装可互换的行为，然后使用委托来决定具体使用那个行为。它实现了全部的算法，而模板方法 是由子类实现某些细节
         *
         *
         */
        Tea tea = new Tea();
        Caffe caffe = new Caffe();
        tea.praparedBeverage();
        caffe.praparedBeverage();
        //模板方法在框架搭建的时候通常被大量使用  不要想一眼认出

        //spring的ioc中的onrefresh方法就是模板方法
        //AbstractApplicationContext

        //InpuStream  中的read方法就是模板方法的实现
        //JDK中的Arrays.sort() -> mergeSort()就是模板方法 其中的Comparer方法就是交由具体的数组对象去实现
        //因为它想提供给所有数组使用 所以定义成了静态方法 而且 数组无法继承它 所以采用这种方式实现模板方法模式

    }
}
