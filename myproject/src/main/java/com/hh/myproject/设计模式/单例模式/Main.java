package com.hh.myproject.设计模式.单例模式;

/**
 *
 * @author hejiayuan
 * @create 2020-06-07-11:46
 */
public class Main {
  public static void main(String[] args) {
        //通过enum枚举类创建单利  保证线程安全和单一实例
        EnumSingleTon.INSTANCE.doSomething();


  }
}
