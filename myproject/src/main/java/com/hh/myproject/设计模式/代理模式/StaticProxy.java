package com.hh.myproject.设计模式.代理模式;

/**
 * @author hejiayuan
 * @create 2020-06-21-21:58
 */
public class StaticProxy {
    public static void main(String[] args) {
        Nike nike = new Nike();

        StaticProxyFac staticProxyFac = new StaticProxyFac(nike);
        staticProxyFac.produce();

    }
}

//接口
interface ClothFactory{
    void produce();
}

//被代理类
class Nike implements ClothFactory{

    @Override
    public void produce() {
        System.out.println("生产nike");
    }
}


//代理类
class StaticProxyFac implements ClothFactory{
    private ClothFactory clothFactory;

    public StaticProxyFac(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produce() {
        System.out.println("代理类做点准备");
        clothFactory.produce();
        System.out.println("代理类做点收尾");
    }
}