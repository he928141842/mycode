package com.hh.myproject.base.面试题3.JUC包;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hejiayuan
 * @create 2021-08-06-10:56
 */
public class AqsDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //流程分解在precessOn
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"a").start();

        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"b").start();

    }
}
