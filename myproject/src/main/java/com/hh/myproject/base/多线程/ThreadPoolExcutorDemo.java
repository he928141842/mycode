package com.hh.myproject.base.多线程;

import java.util.concurrent.*;

/**
 * @author hejiayuan
 * @create 2021-07-25-19:35
 */
public class ThreadPoolExcutorDemo {
    public static void main(String[] args) {

        //线程最大数量是Interge.MAXVALUE  会造成oom
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        /**
         * 线程池的流程：首先新任务进来以后会判断当前线程数量是否达到了核心线程数，没有的话创建核心线程运行
         *              达到了的话将新任务放入阻塞队列中，如果新任务过多导致队列放满了，此时还没有达到最大线程数的话，
         *              就将创建新的线程去执行，达到最大线程数量以后，执行拒绝策略。默认的是AbortPolicy
         *              CallerRunPolicy是指让当前的调用线程去执行此任务
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
