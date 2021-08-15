package com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二;

import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient.Dough;
import com.hh.myproject.设计模式.工厂模式.工厂方法模式.版本二.ingredient.Sauce;
import lombok.Data;

/**
 * @author hejiayuan
 * @date 2021-06-23 14:15
 */
@Data
public abstract class FactoryMethodPizza2 {
    /**
     * 披萨名称
     */
    public String name;

    /**
     * 面团
     */
    public Dough dough;

    /**
     * 酱料
     */
    public Sauce sauce;



    /**
     * 准备方法 2.0  由于每个 分店的原料都是统一工厂生产得
     */
    protected abstract   void prepared();

    //需要重写可以重写
    void bake() {
        System.out.println("烤个20分钟。。。");
    }

    void cut(){
        System.out.println("切片。。。");
    }

    void box(){
        System.out.println("打包。。。"+name);
    }


}
