package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式;

/** 菜单组件为叶子节点和组合节点提供共同的接口
 *  违反了单一责任原则
 *
 * @author hejiayuan
 * @create 2021-07-20-10:16
 */
public abstract class MenuComponent {
    //可能打的菜单项类不支持添加方法 所对于不支持的节点 继承了以后不需要重写
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    public void getChild(int i){
        throw new UnsupportedOperationException();
    }
    //-----------------以上三个是组合方法 组合节点使用到---------------------

    //以下是操作方法被菜单项使用 有一些也可以被菜单使用
    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDesc(){
        throw new UnsupportedOperationException();
    }
    public double getPrice(){
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarain(){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }
}
