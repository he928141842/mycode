package com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.具体聚合类;

import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.Menu;
import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.MenuItem;
import com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器.具体迭代器实现.DinnerMenuIterator;
import lombok.Data;

import java.util.Iterator;

/**
 * @author hejiayuan
 * @create 2021-07-19-20:56
 */
@Data
public class DinnerMenu implements Menu {
    private String name;
    private MenuItem[] menuItems;

    public DinnerMenu() {
        this.name = "午餐菜单";
        this.menuItems =new MenuItem[] {new MenuItem("炒鸡蛋","青椒和鸡蛋",true,10)
            ,new MenuItem("糖醋排骨","排骨和糖",false,50)
            ,new MenuItem("红烧豆腐","豆腐",true,8)};

    }

    @Override
    public Iterator creatIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}
