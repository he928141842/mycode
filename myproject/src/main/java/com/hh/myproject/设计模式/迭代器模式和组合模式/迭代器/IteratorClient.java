package com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器;

import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.具体聚合类.BreakfastMenu;
import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.具体聚合类.DinnerMenu;

import java.util.Iterator;

/**
 * @author hejiayuan
 * @create 2021-07-19-20:49
 */
public class IteratorClient {
    private Menu breakfastMenu;
    private Menu dinnerMenu;

    public IteratorClient(Menu breakfastMenu, Menu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu(){
        Iterator iterator = breakfastMenu.creatIterator();
        Iterator iterator1 = dinnerMenu.creatIterator();
        System.out.println("早餐菜单--");
        printMenuItem(iterator);
        System.out.println("晚餐菜单");
        printMenuItem(iterator1);
    }

    public void printMenuItem(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem item = (MenuItem) iterator.next();
            System.out.print(item.getName()+",");
            System.out.print(item.getPrice()+"--");
            System.out.println(item.getDesc());
        }
    }

    public static void main(String[] args) {
        /**
         * 迭代器模式：提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示
         *
         *
         * 迭代器接口Iterator  聚合接口Menu 以及对应实现类
         *
         * 单一责任：一个类应该只有引起变化的原因
         * 当一个类或者一个模块被设计成只支持一组相关的功能时，称为高内聚
         */
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        IteratorClient iteratorClient = new IteratorClient(breakfastMenu,dinnerMenu);
        iteratorClient.printMenu();

        //jdk代码中的ArrayList的就使用了迭代器模式
        //其中它实现的List接口含有获取Iterator的方法  可以看作是聚合接口
        //而ArrayList就是具体的 聚合实现类
        //而具体的迭代器实现类  这里采用了内部类的方式 Itr类  Itr类可以看作具体的迭代器实现类
    }
}
