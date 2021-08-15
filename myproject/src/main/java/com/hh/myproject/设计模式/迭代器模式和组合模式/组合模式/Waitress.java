package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式;

/**
 * @author hejiayuan
 * @create 2021-07-20-10:38
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printAll(){
        allMenus.print();
    }

    public static void main(String[] args) {
        /**
         * 组合模式：允许你将对象组合成树形结构来表现整体/部分层次结构。
         * 组合能让用户使用一致的方式来处理个别对象以及组合对象  整体/对象  一致处理
         * 树形结构
         */

        MenuComponent breakFast = new Menu2("永和豆浆","早餐店");
        MenuComponent lunch = new Menu2("淮南牛肉汤","午餐店");
        MenuComponent dinner = new Menu2("肯德基","晚餐店");
        MenuComponent dessert = new Menu2("甜品站","卖甜品");

        breakFast.add(new MenuItem2("包子","猪肉包子",2,false));
        breakFast.add(new MenuItem2("油条","榨油条",1,true));

        lunch.add(new MenuItem2("牛肉汤","淮南牛肉汤",15,false) );
        lunch.add(new MenuItem2("烧饼","淮南牛肉汤的烧饼",1,true) );

        dinner.add(new MenuItem2("牛肉汉堡","牛肉汉堡",15,false) );
        dinner.add(new MenuItem2("鸡腿汉堡","鸡腿汉堡",15,false) );
        dinner.add(dessert);

        dessert.add(new MenuItem2("甜筒","甜筒",10,true));
        dessert.add(new MenuItem2("冰淇淋","冰淇淋",10,true));

        MenuComponent allMenu = new Menu2("总菜单","包含所有菜品");
        allMenu.add(breakFast);
        allMenu.add(lunch);
        allMenu.add(dinner);
        Waitress waitress = new Waitress( allMenu);
        waitress.printAll();
        /**
         * spring中的 CompositeCacheManager就用到了组合模式 其中CacheManager接口相当于Component角色
         *  CompositeCacheManager组合对象
         *  而其他的实现 比如 SimpleCacheManager相当于叶对象
         *
         */


    }
}
