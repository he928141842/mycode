package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hejiayuan
 * @create 2021-07-20-10:28
 */
public class Menu2 extends MenuComponent{
    private String menuName;
    private String menuDesc;
    private List<MenuComponent> menuComponents;

    public Menu2(String menuName, String menuDesc) {
        this.menuName = menuName;
        this.menuDesc = menuDesc;
        this.menuComponents = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        this.menuComponents.remove(menuComponent);
    }

    @Override
    public String getName() {
        return this.menuName;
    }

    @Override
    public String getDesc() {
        return this.menuDesc;
    }
    //如果菜单中不光包含菜单项  还有子菜单 则递归打印
    @Override
    public void print() {
        //首先打印菜单名
        System.out.print("\n"+getName());
        System.out.print(","+getDesc());
        System.out.println("-------");
        //遍历菜单内容
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            //这里的MenuComponent既可能是具体菜单项  有可能是 是菜单
            MenuComponent next = iterator.next();
            //如果是菜单项则调用的是菜单项的打印方法 如果是子菜单 则是递归调用此方法
            next.print();
        }

    }
}
