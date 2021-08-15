package com.hh.myproject.设计模式.复合模式.观察者;

/**
 * 首先需要一个被观察的对象
 * Observerble就是一个被观察对象 并且被观察者要实现将观察者注册进来的方法  以及通知到观察者的方法
 *
 * 接下来需要让Quackable接口继承自此类
 * 之前的观察者模式都是 在具体的子类中实现注册和通知 这里采用
 * 在一个新的叫Observerble的类中使用组合模式 将QuackObserverble的所有调用都委托给他
 *
 * @author hejiayuan
 * @create 2021-07-21-20:58
 */
public interface QuackObserverble {

     void registerObserver(DuckObserver observer);
     void notifyObservers();
}
