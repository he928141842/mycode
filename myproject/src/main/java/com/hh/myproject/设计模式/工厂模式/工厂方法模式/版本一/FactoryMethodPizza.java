package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本一;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:15
 */
@Data
public abstract class FactoryMethodPizza {
    /**
     * 披萨名称
     */
    public String name;

    /**
     * 面团
     */
    public String dough;

    /**
     * 酱料
     */
    public String sauce;

    /**
     * 浇头
     */
    public List<String> toppings = new ArrayList<>();

    /**
     * 准备方法 1.0 看作一致处理
     */
    public  void prepared(){
        System.out.println(String.format("准备%s。。。",name));
        System.out.println("揉面中。。。"+dough);
        System.out.println("加酱油。。。"+sauce);
        System.out.println("开始加浇头：");

        toppings.forEach(topping-> System.out.println(" " + topping));
    }

    //需要重写可以重写
    public void bake() {
        System.out.println("烤个20分钟。。。");
    }

    public void cut(){
        System.out.println("切片。。。");
    }

    public void box(){
        System.out.println("打包。。。"+name);
    }


}
