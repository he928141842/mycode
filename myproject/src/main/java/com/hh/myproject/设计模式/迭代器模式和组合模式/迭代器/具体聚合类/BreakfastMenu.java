package com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.具体聚合类;

import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.Menu;
import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.MenuItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hejiayuan
 * @create 2021-07-19-20:56
 */
@Data
public class BreakfastMenu implements Menu {
    private String name;
    private List<MenuItem> menuItems;

    public BreakfastMenu() {
        this.name = "早餐菜单";
        menuItems = new ArrayList<>();
        this.menuItems.add(new MenuItem("油条","油条",true,1));
        this.menuItems.add(new MenuItem("包子","包子",true,2));
        this.menuItems.add(new MenuItem("豆浆","豆浆",true,4));

    }

    @Override
    public Iterator creatIterator() {
        //ArrayList中有获取迭代器的方法
        return menuItems.iterator();
    }
}
