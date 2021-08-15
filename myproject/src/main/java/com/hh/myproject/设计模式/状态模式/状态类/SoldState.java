package com.hh.myproject.设计模式.状态模式.状态类;

import com.hh.myproject.设计模式.状态模式.GumballMachine;
import com.hh.myproject.设计模式.状态模式.State;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:55
 */
public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("正在发放糖果");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你已经转过曲臂");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("你已经转过曲臂，不会再给糖果");
        return false;
    }

    @Override
    public void dispense() {
        gumballMachine.givingGum();
        int count = gumballMachine.getCount();
        if (count == 0){
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());

        }
    }
}
