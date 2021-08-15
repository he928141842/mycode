package com.hh.myproject.设计模式.装饰者.例一;

import com.hh.myproject.设计模式.装饰者.例一.beverages.DarkRoast;
import com.hh.myproject.设计模式.装饰者.例一.beverages.Espresso;
import com.hh.myproject.设计模式.装饰者.例一.decorators.Mocha;
import com.hh.myproject.设计模式.装饰者.例一.decorators.Whip;

/**
 * @author hejiayuan
 * @date 2021-06-16 16:09
 */
public class DecorateMain {
    public static void main(String[] args) {
        // 摩卡 奶泡 烘培咖啡
        Beverage beverage = new DarkRoast();
        //“工厂”和“生成器”设计模
        //式时，将有更好的方式建立被装饰者对象
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        System.out.println(beverage.getDesc()+":"+beverage.cost());

        //双倍摩卡，奶泡 浓咖啡
        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);

        System.out.println(beverage1.getDesc()+":"+beverage1.cost());
        /**
         * BufferedInputStream及LineNumberInputStream都扩展自
         * FilterInputStream，而FilterInputStream是一个抽象的装饰类。
         *
         *
         * 装饰者模式 在jdk中  InputStream 就是一个抽象类  FilterInputStream是一个装饰类
         *  InputStream => BufferedInputStream => LineNumberInputStream

         */

        /**
         * HeadFirst：欢迎装饰者模式，听说你最近情绪有点差？
         * 装饰者：是的，我知道大家都认为我是一个有魅力的设计模式，但是，你知道吗？我也有自己
         * 的困扰，就和大家一样。
         * HeadFirst：愿意让我们分担一些你的困扰吗？
         * 装饰者：当然可以。你知道我有能力为设计注入弹性，这是毋庸置疑的，但我也有“黑暗
         * 面”。有时候我会在设计中加入大量的小类，这偶尔会导致别人不容易了解我的设计方式。
         * HeadFirst：你能够举个例子吗？
         * 装饰者：以Java I/O库来说，人们第一次接触到这个库时，往往无法轻易地理解它。但是如果
         * 他们能认识到这些类都是用来包装InputStream的，一切都会变得简单多了。
         * HeadFirst：听起来并不严重。你还是一个很好的模式，只需要一点点的教育，让大家知道怎么
         * 用，问题就解决了。
         * 装饰者：恐怕不只这些，我还有类型问题。有些时候，人们在客户代码中依赖某种特殊类型，
         * 然后忽然导入装饰者，却又没有周详地考虑一切。现在，我的一个优点是,你通常可以透明地
         * 插入装饰者，客户程序甚至不需知道它是在和装饰者打交道。但是，如我刚刚所说的，有些代
         * 码会依赖特定的类型，而这样的代码一导入装饰者，嘭！出状况了！
         * HeadFirst：这个嘛,我相信每个人都必须了解到，在插入装饰者时，必须要小心谨慎。我不认
         * 为这是你的错！

         * 装饰者：我知道，我也试着不这么想。我还有一个问题，就是采用装饰者在实例化组件时，将
         * 增加代码的复杂度。一旦使用装饰者模式，不只需要实例化组件，还要把此组件包装进装饰者
         * 中，天晓得有几个。
         * HeadFirst：我下周会访谈工厂（Factory）模式和生成器（Builder）模式，我听说他们对这个
         * 问题有很大的帮助。
         * 装饰者：那倒是真的。我应该常和这些家伙聊聊。
         * HeadFirst：我们都认为你是一个好的模式，适合用来建立有弹性的设计，维持开放－关闭原
         * 则。你要开心一点，别负面思考。
         * 装饰者：我尽量吧，谢谢你！
         */


    }
}
