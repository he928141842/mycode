package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式.组合加迭代模式;


import java.util.Iterator;

/**
 * @author hejiayuan
 * @create 3031-07-30-10:38
 */
public class Waitress3 {
    MenuComponent3 allMenus;

    public Waitress3(MenuComponent3 allMenus) {
        this.allMenus = allMenus;
    }

    public void printAll() {
        allMenus.print();
    }

    public void printVegetarain() {
        Iterator iterator = allMenus.creatIterator();
        System.out.println("素菜---");
        while (iterator.hasNext()) {
            //第一次这个next是Menu3
            MenuComponent3 next = (MenuComponent3) iterator.next();
            try {
                if (next.isVegetarain()) {
                    next.print();
                }
            } catch (Exception exception) {

            }
        }
    }

    public static void main(String[] args) {
        MenuComponent3 breakFast = new Menu3("永和豆浆", "早餐店");
        MenuComponent3 lunch = new Menu3("淮南牛肉汤", "午餐店");
        MenuComponent3 dinner = new Menu3("肯德基", "晚餐店");
        MenuComponent3 dessert = new Menu3("甜品站", "卖甜品");

        //breakFast.add(new MenuItem3("包子", "猪肉包子", 3, false));
        //breakFast.add(new MenuItem3("油条", "榨油条", 1, true));
        //
        //lunch.add(new MenuItem3("牛肉汤", "淮南牛肉汤", 15, false));
        //lunch.add(new MenuItem3("烧饼", "淮南牛肉汤的烧饼", 1, true));
        //
        dinner.add(new MenuItem3("牛肉汉堡", "牛肉汉堡", 15, false));
        dinner.add(new MenuItem3("鸡腿汉堡", "鸡腿汉堡", 15, false));
        dinner.add(dessert);

        dessert.add(new MenuItem3("甜筒", "甜筒", 10, true));
        dessert.add(new MenuItem3("冰淇淋", "冰淇淋", 10, true));

        MenuComponent3 allMenu = new Menu3("总菜单", "包含所有菜品");
        allMenu.add(breakFast);
        allMenu.add(lunch);
        allMenu.add(dinner);
        Waitress3 waitress = new Waitress3(allMenu);
        waitress.printVegetarain();

    }
}
