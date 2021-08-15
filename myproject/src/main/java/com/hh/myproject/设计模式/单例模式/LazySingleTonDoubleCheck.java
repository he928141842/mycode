package com.hh.myproject.设计模式.单例模式;

/**
 * @author hejiayuan
 * @create 2020-06-07-11:25
 */
public class LazySingleTonDoubleCheck {

    //使用volatile关键字 内存可见性、指令重排序、原子性  这里是利用内存屏障使共享变量每次的读写都从主内存中取值
    // 内存屏障  StoreStore StoreLoad LoadLoad LoadStore
    // 避免虽然已经拿到对象的地址 但是其实内存中对象还没实例化出来（参数未实例化）
    private static volatile LazySingleTonDoubleCheck INSTANCE;

  // DCL模式的优点就是，只有在对象需要被使用时才创建，第一次判断 INSTANCE == null为了避免非必要加锁，
  // 当第一次加载时才对实例进行加锁再实例化。这样既可以节约内存空间，又可以保证线程安全。
  // 但是，由于jvm存在乱序执行功能(重排序)，DCL也会出现线程不安全的情况。具体分析如下：
  // INSTANCE  = new SingleTon();
  // 这个步骤，其实在jvm里面的执行分为三步：
  //
  //           1.在堆内存开辟内存空间。
  //   2.在堆内存中实例化SingleTon里面的各个参数。
  //   3.把对象指向堆内存空间。
  //
  // 由于jvm存在乱序执行功能，所以可能在2还没执行时就先执行了3，如果此时再被切换到线程B上，由于执行了3，INSTANCE
  // 已经非空了，会被直接拿出来用，这样的话，就会出现异常。这个就是著名的DCL失效问题。
  //
  // 不过在JDK1.5之后，官方也发现了这个问题，故而具体化了volatile，即在JDK1.6及以后，只要定义为private volatile static SingleTon 
  // INSTANCE = null;就可解决DCL失效问题。volatile确保INSTANCE每次均在主内存中读取，这样虽然会牺牲一点效率，但也无伤大雅

  public static LazySingleTonDoubleCheck getINSTANCE() {
        if (INSTANCE == null ) {
            synchronized (LazySingleTonDoubleCheck.class) {
                if (INSTANCE == null ){
                    INSTANCE = new LazySingleTonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
