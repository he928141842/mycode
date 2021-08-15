package com.hh.myproject.base.多线程;

import java.text.SimpleDateFormat;
import java.util.function.Supplier;

/**
 * @author hejiayuan
 * @create 2021-07-24-21:05
 */
public class ThreadLocalDemo {

    public static final ThreadLocal<SimpleDateFormat> t1 = ThreadLocal.withInitial(SimpleDateFormat::new);
    public static  final ThreadLocal<String> t2 = ThreadLocal.withInitial(()-> "1");

    public static void main(String[] args) {

        new Thread(()->{
            SimpleDateFormat simpleDateFormat = t1.get();
            String s = t2.get();
            t1.remove();
            t2.remove();
        }).start();

        new Thread(()->{
            SimpleDateFormat simpleDateFormat = t1.get();
            String s = t2.get();
            t1.remove();
            t2.remove();
        }).start();

        /**
         * ThreadLocal:作用 用来保存线程私有的变量，场景比较经典的有多线程情况下使用SimpdateFormate类
         *          （使用java8的DateTimeFormate可以避免），登陆信息User在上下文（context）中的的传递
         *      原理：Thread类中有一个属性 Threadlocal.ThreadlocalMap 创建现成的时候，每个线程都有属于自己的
         *          ThreadlocalMap所以可以实现线程私有。
         *          在有多个线程私有变量的时候 ThreadLocal<String> a = new ThreadLocal();
         *          ThreadLocal<String> b = new ThreadLocal();
         *
         *          多个ThreadLocal实例共用一个静态内部类ThreadLocalMap（因为ThreadLocalMap是同一个线程Thread下面的属性
         *          ，不管这个线程有几个私有变量，都是从一个线程对象找map）
         *
         *          ThreadlocalMap内部通过Entry数组来保存

         *          使用静态内部类ThreadLocalMap来实现，虽然叫map但是内部并没有采用双向链表那种实现
         *          而是通过Entry类继承弱引用类WeakReference实现 ThreadLocalMap中有entry数组，用来保存
         *
         *          多个线程私有变量，这样就有问题，没有了链表怎么解决Hash冲突呢？
         *          解决方式就是线性探测，如果当前位置i = key.threadLocalHashCode & (len-1);的Entry不为空的话
         *          就调用nextIndex方法将i+1 继续探索，直到为空为止，如果冲突严重效率很低。
         *
         *          想要共享线程的ThreadLocal数据怎么办？
         *          使用它的InheritableThreadLocal  在初始化子线程的时候会拷贝一份父线程的map过来
         *
         *          为什么要把ThreadLocal设置成弱引用(Entry继承了但是是把ThreadLocal设成弱引用的)。
         *          .static class Entry extends WeakReference<ThreadLocal<?>>
         *            是一种保证，如果外面对ThreadLocal对象的强引用不存在了，那么将它的实例对象设置成 弱引用（这里就是key）
         *            会保证他会在下次gc时被回收，保证ThreadLocal对象被回收，避免内存泄漏，同时还得调用remove方法，将它的
         *            entry对象的引用设为null，value的强引用设为null。（不然就会出现null --- value value强引用一直存在）
         *
         *            如果在面一直有ThreadLocal对象的强引用，比如使用static或者全局变量的ThreadLocal，那么ThreadLocal对象就一直
         *            有一个强引用。但是如果存在线程复用，那么还是存在每个线程的value一直回收不掉的情况，
         *            所以调用remove方法看来是必须的
         *
         *          expungeStaleEntry(int staleSlot)
         *             // expunge entry at staleSlot
         *             tab[staleSlot].value = null;
         *             tab[staleSlot] = null;
         *          。（我个人的理解）
         *
         *
         *
         *
         *
         */
    }

}
