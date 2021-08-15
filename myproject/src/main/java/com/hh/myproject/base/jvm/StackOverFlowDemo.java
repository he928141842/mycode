package com.hh.myproject.base.jvm;

/**
 * @author hejiayuan
 * @create 2021-08-10-10:16
 */
public class StackOverFlowDemo {
    public static int i = 0;

    //默认11421  -Xss设置栈空间为256k以后  输出2474  抛出StackOverflowError
    //栈不会gc 但是会oom   他只有256k来存放要执行的命令  超出了就会报错
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000000);
        //System.out.println(i);
        //i++;
        //main(args);
    }
}
