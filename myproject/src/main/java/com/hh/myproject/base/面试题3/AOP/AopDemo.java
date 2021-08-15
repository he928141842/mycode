package com.hh.myproject.base.面试题3.AOP;

/**
 * @author hejiayuan
 * @create 2021-08-06-16:01
 */
public class AopDemo {
    public static void main(String[] args) {
        /**
         * spring5之后的通知执行顺寻变了
         */
        //spring4执行流程是  Around -》 Before -》 方法执行 -》Around -》 after -》afterReturning
        //spring4异常执行流程是  Around -》 Before -》 方法执行 -》  after -》afterThrowing

        //spring5可以看成是
        //Around 方法
        try {
            //Before方法
            //方法执行
            // 3 AfterReturning  34只会执行一个4异常时
        }catch (Exception e){
            // 4 AfterThrowing
        }finally {
            //After
        }
        //Around方法  在4执行时不会执行




    }
}
