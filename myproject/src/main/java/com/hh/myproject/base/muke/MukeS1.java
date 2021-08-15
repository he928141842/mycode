package com.hh.myproject.base.muke;

/**
 * @author hejiayuan
 * @date 2021-01-18 16:25
 */
public class MukeS1 {
    private int result = 0;
    private int number = 1;
    private boolean ready = false;
    //写
    public void write(){
        ready = true;
        number = 2;
    }
    //读
    public void read(){
        if(ready){
            result = number * 3;
        }
        System.out.println("result:" + result);
    }
    public static void main(String[] args) {
        /**
         * 1、java内存模型
         *  可见性的实现   线程1更新变量  =》主内存更新变量值 =》 线程2获取主内存的值
         *  实现方式：（语言层面）
         *  1、synchronized 保证锁内操作原子性 实现可见性  原因  线程交叉执行  资源更新不及时
         *      1、获得互斥锁  2 清空工作内存 3 从主内存中拷贝过来  4 执行代码 5 更改后的变量刷新到主内存 6 释放互斥锁
         *
         *  as-if-serial  无论如何重排序  最终结果一致 （单线程不存在重排序问题，因为as-if-serial保证最终结果一致）
         *
         *  2、volitile  可见性  内存屏障 store强制变更刷新到主内存  load读取从主内存读取
         *
         *
         *
         */
    }
}
