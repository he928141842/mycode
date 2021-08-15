package com.hh.myproject.设计模式.状态模式.状态类;

import com.hh.myproject.设计模式.状态模式.GumballMachine;
import com.hh.myproject.设计模式.状态模式.State;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:55
 */
public class WinnerState implements State {

    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已经投入硬币。");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("正在投放，无法退币");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("正在投放，不需要再转动");
        return false;
    }

    @Override
    public void dispense() {
        //为什么这里不直接转换成sould状态在里面判断，发送两次呢？
        //一个类一个责任
        System.out.println("你是今晚的赢家，你将得到两颗糖果");
        gumballMachine.givingGum();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else {
            gumballMachine.givingGum();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            }else {
                System.out.println("没货了");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
