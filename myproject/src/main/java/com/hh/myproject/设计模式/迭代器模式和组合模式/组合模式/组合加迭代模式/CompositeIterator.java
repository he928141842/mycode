package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式.组合加迭代模式;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author hejiayuan
 * @create 2021-07-20-11:16
 */
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()){
            return false;
        }else {
            Iterator iterator = (Iterator) stack.peek();//始终是取出最上层的 在早餐店没遍历完之前一直是早餐店 以此类推
            if (!iterator.hasNext()) {//此时是进入一个新的CompositeIterator对象的hasNext方法
                stack.pop();
                return hasNext();
            }else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()){
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent3 menuComponent3 = (MenuComponent3) iterator.next();
            if(menuComponent3 instanceof Menu3){
                stack.push(menuComponent3.creatIterator());//始终保持最开始的栈中有两层 第一层放的是总的那个CompositeIterator 第二层放的是具体的早餐 午餐 晚餐CompositeIterator
            }
            return menuComponent3;
        }else {
            return null;
        }

    }
}
