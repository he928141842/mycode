package com.hh.myproject.base.LeetCode;

/**
 * @author hejiayuan
 * @date 2020-10-23 17:35
 */
public class MainTest {
    /**
     * 三个不同的线程将会共用一个foo实例。
     *
     * 线程 A 将会调用 first() 方法
     * 线程 B 将会调用 second() 方法
     * 线程 C 将会调用 third() 方法
     * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
     *
     */
    Foo f = new Foo();

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {

        }
    });
}

class Foo {

    

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

