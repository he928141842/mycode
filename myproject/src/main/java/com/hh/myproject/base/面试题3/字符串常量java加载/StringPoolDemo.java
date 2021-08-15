package com.hh.myproject.base.面试题3.字符串常量java加载;

/**
 * @author hejiayuan
 * @create 2021-08-05-20:33
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        //如果常量池中已经有这个字符串  则直接返回引用 所以是true
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        //为什么返回false  因为java是已经定义在Version类中过的final 常量 所以这intern返回的和拼接的不是一个
        System.out.println(str2 == str2.intern());

    }
}
