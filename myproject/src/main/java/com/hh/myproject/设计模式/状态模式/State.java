package com.hh.myproject.设计模式.状态模式;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:52
 */
public interface State {
    //投币
    void insertQuarter();
    //退币
    void ejectQuarter();

    //转动 返回布尔值避免了 每次转动  不管什么情况都调用了发放方法
    boolean turnCrank();
    //出货
    void dispense();
}
