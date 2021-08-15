package com.hh.myproject.设计模式.迭代器模式和组合模式.迭代器;

import lombok.Data;

/** 菜品
 * @author hejiayuan
 * @create 2021-07-19-20:52
 */
@Data
public class MenuItem {
    private String name;
    private String desc;
    //是否是素食
    private boolean isVegatarain;
    private double price;

    public MenuItem(String name, String desc, boolean isVegatarain, double price) {
        this.name = name;
        this.desc = desc;
        this.isVegatarain = isVegatarain;
        this.price = price;
    }


}
