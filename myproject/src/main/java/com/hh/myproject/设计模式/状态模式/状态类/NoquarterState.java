package com.hh.myproject.设计模式.状态模式.状态类;

import com.hh.myproject.设计模式.状态模式.GumballMachine;
import com.hh.myproject.设计模式.状态模式.State;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:55
 */
public class NoquarterState implements State {

    private GumballMachine gumballMachine;

    public NoquarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("投入硬币。");
        //投入硬币后状态变为 haveQuarter
        gumballMachine.setState(gumballMachine.getHaveQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没有硬币退还。");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("转动曲臂，但是没有付钱。");
        return false;
    }

    @Override
    public void dispense() {
        System.out.println("需要先付钱。");
    }
}
