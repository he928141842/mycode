package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式.组合加迭代模式;

import java.util.Iterator;

/**
 * @author hejiayuan
 * @create 2021-07-20-11:25
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
