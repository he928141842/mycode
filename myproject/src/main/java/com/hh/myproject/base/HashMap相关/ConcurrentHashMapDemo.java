package com.hh.myproject.base.HashMap相关;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hejiayuan
 * @create 2021-07-26-11:20
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        /**
         * 多线程put的时候首先会初始化，cas修改底层数组的长度等等h
         * 然后获取当前key的hashcode
         * 接下来会tabAt从内存中获取当前的位置上数组的值  如果为null的话则cas尝试修改
         * 此时其他线程也走到这一步的话 由于cas期望值应该是null  但是上个县城已经修改成功了 那么他会进行下一次循环 重新判断
         * 如果它的位置上的数组的值不为null  则发生了hash冲突 使用sychronized加锁（对当前数组位置的Node对象） 如果是链表结构 则尝试对此位置上的Node对象加锁
         * 并且修改 该尾部添加尾部添加 该覆盖覆盖
         * https://mp.weixin.qq.com/s?__biz=MzAwNDA2OTM1Ng==&mid=2453141162&idx=1&sn=72976d5ae28ca6e7cdeaef407d3fe2ca&scene=21#wechat_redirect
         *
         * 并且Node他的value和Next节点都是用volitile关键字保证了可见性的
         * 1.7是使用内部的Segment类 它继承自ReentrantLock
         * 底层结构时数组加链表
         * 采用的是对数组的桶枷锁的方式去保证并发，同时数组节点的value和next节点也是用volitile修饰保证可见性
         * 这种方式理论上在容量为16时最大支持并发的线程数量也是16，但是链表的话遍历查找效率不高
         * get方式是无锁的所以比较搞笑
         *
         *
         * aba问题怎么解决呢  就是一个线程从a将值改到b了 另一个将b又改回a  其他线程就不知道发生了修改
         * 很多场景只追求结果正确这个也没有影响，解决的话可以通过加版本号 时间戳等
         *
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                Person p = new Person();
                p.name = Thread.currentThread().getName();
                concurrentHashMap.put(p,p);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(run1);
        executorService.execute(run1);

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
    }
}
class Person {
    String name;

    //equals返回false
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    //构造hash冲突
    @Override
    public int hashCode() {
        return 1;
    }
}