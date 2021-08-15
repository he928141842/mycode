package com.hh.myproject.设计模式.状态模式;

import com.hh.myproject.设计模式.状态模式.状态类.*;
import lombok.Data;

/**
 * @author hejiayuan
 * @create 2021-07-20-19:56
 */
@Data
public class GumballMachine {
    private State noQuarterState;
    private State haveQuarterState;
    private State soldState;
    private State soldOutState;
    private State winnerState;
    //初始状态
    private State state;

    private int count;

    public GumballMachine(int count) {
        //这些状态类不能有多个实例
        this.noQuarterState = new NoquarterState(this);
        this.haveQuarterState = new HaveQuarterState(this);
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.winnerState = new WinnerState(this);
        this.state = noQuarterState;
        this.count = count;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }


    public void ejectQuarter() {
        state.ejectQuarter();
    }


    public void turnCrank() {
        if (state.turnCrank()){
            //不需要在机器类中有发放动作，用户不可以直接请求发放 发放糖果前的状态是必须的
            //这里的state和上面的state已经不一样了 已经在上一个turn方法中改变了状态
            state.dispense();
        }
    }
    public void givingGum(){
        System.out.println("滚出了一个糖果。。");
        //状态的转变应该在具体的状态类中去 除非是比较固定的状态转换
        if (count != 0) {
            count -= 1;
        }
    }
}
