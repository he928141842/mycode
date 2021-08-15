package com.hh.myproject.base.多线程;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hejiayuan
 * @create 2021-07-25-14:42
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /**
         * 多个线程之间相互等待
         */
        //CyclicBarrier barrier = new CyclicBarrier(3);  //①
        //Runner runner1 = new Runner(barrier, "张三");
        //Runner runner2 = new Runner(barrier, "李四");
        //Runner runner3 = new Runner(barrier, "王五");
        //
        //ExecutorService service = Executors.newFixedThreadPool(3);
        //service.execute(runner1);
        //service.execute(runner2);
        //service.execute(runner3);
        //
        //service.shutdown();

        /**
         * 一种同步辅助，允许一组线程全部等待 * 彼此到达公共屏障点。
         * CyclicBarriers * 在涉及固定大小的线程组的程序中很有用， *
         * 必须偶尔互相等待。屏障被称为 * <em>循环</em> 因为它可以在等待线程
         *  被释放后重新使用。
         *  CyclicBarrier构造函数的第二个参数可以传入一个Runnable实现 在所有线程到达等待点后首先执行这个方法
         *  设计固定大小的线程组的时候（这里parties=2 线程池也为2 ）可以实现分组进行
         *  这个就是屏障的重复使用
         */
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("等裁判吹口哨...");
                    //这里停顿两秒更便于观察线程执行的先后顺序
                    Thread.sleep(2000);
                    System.out.println("裁判吹口哨->>>>>");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Runner runner1 = new Runner(barrier, "张三");
        Runner runner2 = new Runner(barrier, "李四");
        Runner runner3 = new Runner(barrier, "王五");
        Runner runner4 = new Runner(barrier, "赵六");

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(runner1);
        service.execute(runner2);
        service.execute(runner3);
        service.execute(runner4);

        service.shutdown();
    }
}
class Runner implements Runnable{

    private CyclicBarrier barrier;
    private String name;

    public Runner(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            //模拟准备耗时
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(name + ":准备OK");
            barrier.await();
            System.out.println(name +": 开跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}