package com.hh.myproject.base.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * aqs实现原理
 *
 * @author hejiayuan
 * @create 2021-07-31-19:01
 */
public class ReentrantLockDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            reentrantLock.lock();
            try {


            }finally {
                reentrantLock.unlock();
            }
        });
        executorService.execute(() -> {
            reentrantLock.lock();
            try {


            }finally {
                reentrantLock.unlock();
            }
        });


    }
}
