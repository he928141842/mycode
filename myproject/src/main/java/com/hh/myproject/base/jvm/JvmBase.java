package com.hh.myproject.base.jvm;

/**
 * @author hejiayuan
 * @date 2021-01-21 14:48
 */
public class JvmBase {
    public static final int [] a = new int[1024*1024*100];

    public static void main(String[] args) throws InterruptedException {
        JvmBase jvmBase = new JvmBase();
        Thread.sleep(10000000);

    }
}
