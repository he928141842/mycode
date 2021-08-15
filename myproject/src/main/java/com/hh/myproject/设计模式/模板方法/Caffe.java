package com.hh.myproject.设计模式.模板方法;

/**
 * @author hejiayuan
 * @create 2021-07-19-15:24
 */
public class Caffe extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("往杯子中加入咖啡豆。。");
    }

    @Override
    public void addCondiments() {
        System.out.println("加入牛奶、糖。。");
    }


}
