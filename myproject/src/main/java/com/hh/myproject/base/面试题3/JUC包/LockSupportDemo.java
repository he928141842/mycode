package com.hh.myproject.base.面试题3.JUC包;

import java.util.concurrent.locks.LockSupport;

/**
 * @author hejiayuan
 * @create 2021-08-05-21:54
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        /**
         * LockSupport 的unpark方法会将一个类似（Semphare信号量）peimit的计数加1 最高也只能是1 多次调用没用
         * park方法在peimit为0的时候会挂起当前线程 1则放行
         */
        Thread a = new Thread(()->{
            System.out.println("a进来了");
            LockSupport.park();
            System.out.println("a出来了");

        },"a");
        a.start();
        Thread b = new Thread(()->{
            System.out.println("b进来了");
            LockSupport.unpark(a);
            System.out.println("b出来了");

        },"b");
        b.start();

    }
}
