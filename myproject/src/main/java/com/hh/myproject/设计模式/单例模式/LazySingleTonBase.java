package com.hh.myproject.设计模式.单例模式;

/**
 * @author hejiayuan
 * @create 2020-06-07-11:16
 */
public class LazySingleTonBase {
    private static LazySingleTonBase INSTANCE;
    //懒汉模式在方法被调用后才创建对象，以时间换空间，在多线程环境下存在风险。
    private static LazySingleTonBase getINSTANCE(){
        if (null == INSTANCE){
            INSTANCE= new LazySingleTonBase();
        }
        return INSTANCE;
    }

}
