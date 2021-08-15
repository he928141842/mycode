package com.hh.myproject.设计模式.状态模式;

/**
 * @author hejiayuan
 * @create 2021-07-20-20:29
 */
public class StateMain {
    public static void main(String[] args) {
        /**
         * 重要的点 找到所有的状态  可能存在的动作
         */
        GumballMachine gumballMachine = new GumballMachine(5);
        //System.out.println("一共还有："+gumballMachine.getCount());
        //gumballMachine.insertQuarter();
        //gumballMachine.turnCrank();
        //System.out.println("一共还有："+gumballMachine.getCount());
        //gumballMachine.insertQuarter();
        //gumballMachine.turnCrank();
        //gumballMachine.insertQuarter();
        //gumballMachine.turnCrank();
        //System.out.println("一共还有："+gumballMachine.getCount());

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        //如果GumballMachine对象不止一个实例  那么他的状态类都需要变成静态变量
        //所有的GumballMachine共享它的状态 以及 数量
    }
}
