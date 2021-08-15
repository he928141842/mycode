package com.hh.myproject.base.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/**
 * @author hejiayuan
 * @create 2021-07-22-17:13
 */
public class CallableTest {
    public static void main(String[] args) {
        Callable callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "kaokaokao";
            }

        };

        FutureTask<String> task = new FutureTask(callable);
        new Thread(task).start();
        try {
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("11111");
    }
}
