package com.hh.myproject.base.多线程;

import javafx.concurrent.Worker;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 总结：countDownLatch这个例子实现的是主线程子线程之间相互等待（CyclicBarrier实现更方便）。
         *      也可以实现主线程等待多个子线程
         *      类说明中有例子，它是计数器减到0才能继续被阻塞的线程，无法重复使用
         *
         */
        int n = 2;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(n);

        for (int i = 0; i < n; ++i) { // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        doSomethingElse();            //  don't let run yet
        startSignal.countDown();      // 走到这里才让子线程里的run方法开始
        doSomethingElse();
        doneSignal.await();// wait for all to finish 这里停止主线程 等两个子线程countDown完了以后才继续
        System.out.println("全高完了。。");
    }

    public static void doSomethingElse(){
        System.out.println("somtething else.....");
    }

    static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();//子线程开始等待 主线程countDown
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException ex) {
            } // return;
        }

        void doWork() {

            System.out.println("do work。。");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

