package com.hh.myproject.设计模式.单例模式;

/**
 * @author hejiayuan
 * @create 2020-06-07-11:19
 */
public class LazySingleTonSync {
    private  static LazySingleTonSync INSTANCE;
  // 这种方法会存在保证线程安全,但是该方法不高效。因为创建对象时，只需要在第一次创建时才需要加锁同步，但是此方法
  // 的实现导致了每次调用instance方法都要加锁，有点多余
  public static LazySingleTonSync getINSTANCE() {
        //因为是静态方法 所以锁不能是this  没有实例化对象  应该用.class 类对象虚拟机加载只会一次 所以是唯一的

        synchronized (LazySingleTonSync.class){
            if (INSTANCE == null) {
                INSTANCE = new LazySingleTonSync();
            }
        }
        return INSTANCE;
    }
}
