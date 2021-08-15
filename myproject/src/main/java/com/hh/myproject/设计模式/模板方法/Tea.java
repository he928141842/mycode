package com.hh.myproject.设计模式.模板方法;

/**
 * @author hejiayuan
 * @create 2021-07-19-15:25
 */
public class Tea extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("往杯中加入茶叶。。");
    }

    @Override
    public void addCondiments() {
        System.out.println("加入少量柠檬。。");
    }

    //通过钩子方法去参与超类的算法
    @Override
    public boolean hook() {
        return false;
    }
}
