package com.hh.myproject.设计模式.状态模式.状态类;

import com.hh.myproject.设计模式.状态模式.GumballMachine;
import com.hh.myproject.设计模式.状态模式.State;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:55
 */
public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("糖果售罄");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("还没有投币");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("糖果售罄");
        return false;
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果");
    }
}
