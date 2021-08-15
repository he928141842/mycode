package com.hh.myproject.设计模式.适配器模式以及外观模式.适配器;

/**
 * @author hejiayuan
 * @create 2021-07-18-17:41
 */
public class DuckAdaptor implements Duck2{
    private Turkey2 turkey2;

    //通过聚合的方式将需要适配的类组合起来
    public DuckAdaptor(Turkey2 turkey2) {
        this.turkey2 = turkey2;
    }

    @Override
    public void gobble() {
        turkey2.turkeyGobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey2.turkeyFly();
        }
    }
}
