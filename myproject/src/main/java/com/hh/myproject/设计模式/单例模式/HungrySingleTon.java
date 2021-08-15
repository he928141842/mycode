package com.hh.myproject.设计模式.单例模式;

/**
 * @author hejiayuan
 * @create 2020-06-07-11:14
 */
public class HungrySingleTon {

    //饿汉模式在类被初始化时就已经在内存中创建了对象，以空间换时间，故不存在线程安全问题

    private  static HungrySingleTon INSTANCE = new HungrySingleTon();

    public static HungrySingleTon getINSTANCE(){
        return INSTANCE;
    }

}
