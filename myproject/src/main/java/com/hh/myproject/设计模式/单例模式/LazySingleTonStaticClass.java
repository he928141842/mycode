package com.hh.myproject.设计模式.单例模式;

/**
 * @author hejiayuan
 * @create 2020-06-07-11:30
 */
public class LazySingleTonStaticClass {
  // 静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，
  // 故而不占内存。即当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，
  // 只有当getInstance()方法第一次被调用时，才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，
  // 这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。

  // 原理
  // 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，
    // 那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
    // 如果在一个类的<clinit>()方法中有耗时很长的操作，就可能造成多个进程阻塞(需要注意的是，其他线程虽然会被阻塞，
    // 但如果执行<clinit>()方法后，其他线程唤醒之后不会再次进入<clinit>()方法。同一个加载器下，一个类型只会初始化一次。)，
    // 在实际应用中，这种阻塞往往是很隐蔽的。
  // 故而，可以看出INSTANCE在创建过程中是线程安全的，所以说静态内部类形式的单例可保证线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。

  private static class SingleTonHolder {
        private static LazySingleTonStaticClass INSTANCE = new LazySingleTonStaticClass();
    }

    public static LazySingleTonStaticClass getINSTANCE(){
        return SingleTonHolder.INSTANCE;
    }
}
