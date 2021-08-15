package com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.具体迭代器实现;

import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.MenuItem;

import java.util.Iterator;

/**
 * @author hejiayuan
 * @create 2021-07-19-21:01
 */
public class DinnerMenuIterator implements Iterator {
    private MenuItem[] menuItems;
    private int location = 0;

    public DinnerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (location >= menuItems.length || menuItems[location] == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object ele = menuItems[location];
        location += 1;
        return ele;
    }
}
