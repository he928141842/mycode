package com.hh.myproject.设计模式.状态模式.状态类;

import com.hh.myproject.设计模式.状态模式.GumballMachine;
import com.hh.myproject.设计模式.状态模式.State;

import java.util.Random;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:55
 */
public class HaveQuarterState implements State {

    private GumballMachine gumballMachine;
    private Random random = new Random();

    public HaveQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已经投入硬币。");

    }

    @Override
    public void ejectQuarter() {
        System.out.println("退还硬币。。");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public boolean turnCrank() {
        System.out.println("成功转动曲臂。");
        int i = random.nextInt(10);
        if (i == 1 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        return true;
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果发放。");
    }
}
