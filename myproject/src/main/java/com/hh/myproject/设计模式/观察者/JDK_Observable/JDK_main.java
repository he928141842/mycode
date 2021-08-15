package com.hh.myproject.设计模式.观察者.JDK_Observable;

import java.util.Observer;

/**
 * @author hejiayuan
 * @date 2021-04-27 17:14
 */
public class JDK_main {

    /**
     * jdk自带的观察者模式  模板
     *  1、Observable （被观察者、可被观察、发布者） Observer（观察者）
     *  2、发布者继承 Observable类 在被观察对象中的数据更新时  调用setChanged()方法 标记改变
     *      并调用notifyObservers()方法 （其中会循环调用观察者的Update方法）
     *  3、观察者实现Observer接口 在其中处理业务逻辑  并添加Observable形参的构造函数
     *      显示调用 addObserver()方法  将自己注册到被观察者的集合中去
     *
     *
     */


    public static void main(String[] args) {
        WeatherData2 weatherData2 = new WeatherData2();

        Observer observer = new CurrentConditionsDisplay2(weatherData2);

        weatherData2.setMeasurements(1,2,3);
    }
}
