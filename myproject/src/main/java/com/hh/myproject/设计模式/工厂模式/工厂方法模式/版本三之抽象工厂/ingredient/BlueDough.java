package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本三之抽象工厂.ingredient;

/**
 * @author hejiayuan
 * @date 2021-06-23 17:36
 */
public  class BlueDough implements Dough3 {
    private String name;

    @Override
    public String getName() {
        return "蓝色面团";
    }
}
