package com.hh.myproject.base.jvm.类加载有关;

import com.hh.myproject.base.jvm.JvmBase;

/**
 * @author hejiayuan
 * @create 2021-08-15-9:55
 */
public class FatherSon {
    //成员变量（非静态的）赋值过程  1、默认初始化 准备阶段  2、显式初始化  代码块  3、构造器初始化 4、有对象以后初始化
    int x = 10;
    public FatherSon() {
        this.print();
        x = 20;
    }

    public void print(){
        System.out.println("father.x:"+x);
    }

    public static void main(String[] args) {
        //看字节码容易得出结论
        FatherSon a = new Son();
        System.out.println(a.x);
        /**
         * son.x:0  调用父类的构造器 此时父类的x已经经过默认初始化 显示初始化 = 10 但是print方法被重写了
         * 此时调用的是子类的print方法  由于此时子类刚刚加载 处于默认初始化 x=0
         *
         * son.x:31 开始调用子类的构造器 已经经过前面两步初始化  print方法时此时 x=31
         * 20
         */

    }

}

class Son extends FatherSon{
    int x = 30;
    {
        x= 31;
    }
    public Son() {
        this.print();
        x = 40;
    }
    @Override
    public void print(){
        System.out.println("son.x:"+x);
    }
}