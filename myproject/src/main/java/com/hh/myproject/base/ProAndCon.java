package com.hh.myproject.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hejiayuan
 * @date 2021-01-07 10:38
 */
public class ProAndCon {
    public static void main(String[] args) {
        List list =new ArrayList();

        ProThread proThread1=new ProThread(list);
        ProThread proThread2=new ProThread(list);
        ConThread conThread1=new ConThread(list);
        ConThread conThread2=new ConThread(list);
        proThread1.setName("生产1");

        conThread1.setName("消费1");
        conThread2.setName("消费2");

        proThread1.start();
        conThread1.start();
        conThread2.start();
    }
}
//生产线程
class ProThread extends Thread{
    private  List list;
    ProThread(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (list.size() > 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object object = new Object();
                list.add(object);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "生产 list" + object);
                list.notifyAll();
            }
        }
    }
}
//消费线程

class  ConThread extends  Thread{
    private  List list;
    public ConThread(List list) {
        this.list=list;
    }
    @Override
    public void run() {

        while (true){
            synchronized (list){
                while (list.size()==0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object object= list.remove(0);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"消费 list"+object);
                list.notifyAll();
            }
        }
    }
}
