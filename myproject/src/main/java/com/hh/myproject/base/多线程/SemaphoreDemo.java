package com.hh.myproject.base.多线程;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        /**
         *信号量 Semaphore 用来控制同一时间内资源可被访问的线程数量，一般用于流量的控制
         **/

    }
}

class Pool {
    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        //这里信号量只是为了表明线程去尝试获取信号  有资格运行  但是可能同时运行5个线程
        //所以真正运行的方法Synchronize的锁和这个不是一个
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x)) {
            available.release();
        }
    }

    // Not a particularly efficient data structure; just for demo

    protected Object[] items;  //... whatever kinds of items being managed
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    //信号量封装了限制访问池所需的同步，与维护池本身一致性所需的同步分开
    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}