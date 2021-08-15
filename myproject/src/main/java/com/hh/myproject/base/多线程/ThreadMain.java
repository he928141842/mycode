package com.hh.myproject.base.多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hejiayuan
 * @create 2021-07-22-17:00
 */
public class ThreadMain {
    public static void main(String[] args) {

        /**
         * 实现锁的几种方式：
         *      1、继承Thread类 2、实现Runnable接口 3、实现Callable接口
         *      实现Callable接口适用于有返回值的场景，使用FutureTask来获取返回值，需要注意的是
         *      FutureTask的get方法会阻塞当前线程
         *      2、Sychronized关键字实现同步和lock接口（ ReentrantLock）实现同步
         *          Sychronized是关键字，而ReentranLock是一个类，通过继承AQS类来实现可重入，内部有一个Sync类继承了AQS类并且重写
         *              了他的一些模板方法
         *          Sychronized 不需要手动释放锁 而 ReentranLock需要手动释放锁
         *          sync采用object的wait notify来实现线程间的通信，而reentrantlock通过AQS的ConditionObject实现Condition的await 和signal方法来实现
         *          sync不可中断 而Lock（reentrantlock实现的接口）可中断可不中断
         *          lock可以使用reentrantReadWritelock实现读锁来提高多线程读的效率
         *          sync是非公平锁 lock可以实现公平也可以非公平  lock中的api比较丰富，提供了一些高级功能
         *                      比如说可以获取当前拥有锁的线程，获取等待中的线程以及设置获取锁的时间等
         *
         *          Sychronized在1.6以后做了优化，他的原理是使用了对象头的mark word去保存一些monitor对象的信息来实现锁的升降级，
         *              从无锁状态到偏向锁，偏向锁的场景是同一个线程多次获取锁的时候比较mark word中的线程id如果一致，标志位加一。且不在惊醒同步操作
         *              轻量级锁是存在少量竞争的情况下通过拷贝锁对象的对象头mark word到当前线程的栈帧的 lock record通过cas尝试更新成当前对象的locak record地址
         *              成功则获取锁，失败则升级成自旋锁 通过循环cas来不停尝试获取锁。
         *              如果尝试10次还没有获取到则升级成重量级锁，阻塞所有未获得锁的线程防止cpu空转
         *          锁升级https://blog.csdn.net/zzti_erlie/article/details/103997713
         *
         *
         */

    }
}
