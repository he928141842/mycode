package com.hh.myproject.设计模式.复合模式;

import com.hh.myproject.设计模式.复合模式.抽象鸭子工厂.AbstractDuckFactory;
import com.hh.myproject.设计模式.复合模式.抽象鸭子工厂.CountingDuckFactory;
import com.hh.myproject.设计模式.复合模式.观察者.Quackologist;
import com.hh.myproject.设计模式.复合模式.鸭子装饰者.QuackCounterDecrator;
import com.hh.myproject.设计模式.复合模式.鸭群组合.Flock;
import com.hh.myproject.设计模式.复合模式.鹅类.Goose;
import com.hh.myproject.设计模式.复合模式.鹅类.GooseAdapter;

/**鸭子模拟器：产生鸭子 并且确认他会叫
 * @author hejiayuan
 * @create 2021-07-21-19:37
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();
        duckSimulator.simulate(abstractDuckFactory);

    }
    void simulate(AbstractDuckFactory abstractDuckFactory){
        //1、确认鸭子会叫
        //Quackable mallardDuck = new MallardDuck();
        //Quackable redHeadDuck = new RedHeadDuck();
        //Quackable duckCallDuck = new DuckCall();
        //2 想要将 老鹅也算进来
        Quackable goose = new GooseAdapter(new Goose());
        //3、想要统计鸭子一共叫了多少次 在不改变这么多鸭子类的前提下 使用装饰者模式来增加新的行为 1、注释掉
        //使用装饰者来为鸭子增加新的行为 也就是在叫的时候 计数  不想把鹅叫也计算进去
        //Quackable mallardDuck = new QuackCounterDecrator(new MallardDuck());
        //Quackable redHeadDuck = new QuackCounterDecrator(new RedHeadDuck());
        //Quackable duckCallDuck = new QuackCounterDecrator(new DuckCall());
        //4、将创建鸭子的程序集中在一个地方 将创建和装饰的部分包装起来
        // 使用抽象工厂
        Quackable mallardDuck = abstractDuckFactory.createMallardDuck();
        Quackable redHeadDuck =abstractDuckFactory.createRedHeadDuck();
        Quackable duckCallDuck = abstractDuckFactory.createDuckCallDuck();
        //5、要分别管理这些鸭子有些困难，想把鸭子作为一个整体来管理。
        //需要将鸭子视为集合，甚至是子集合  组合模式
        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCallDuck);
        flock.add(goose);
        //再创建一个绿头鸭群作为上面鸭群的子集
        Flock mallardDucks = new Flock();
        mallardDucks.add(abstractDuckFactory.createMallardDuck());
        mallardDucks.add(abstractDuckFactory.createMallardDuck());
        mallardDucks.add(abstractDuckFactory.createMallardDuck());
        mallardDucks.add(abstractDuckFactory.createMallardDuck());
        flock.add(mallardDucks);

        System.out.println("-------鸭子模拟器----");
        //simulate(mallardDuck);
        //simulate(redHeadDuck);
        //simulate(duckCallDuck);
        //simulate(goose);

        //5、测试一整群鸭子
        //System.out.println("测试一整群鸭子。");
        //simulate(flock);
        //System.out.println("只测试绿头鸭子群。");
        //simulate(mallardDucks);
        //6、只追踪个别鸭子的叫 这里使用观察者模式
        //实例化观察者
        Quackologist quackologist = new Quackologist();
        //观察全部鸭群
        flock.registerObserver(quackologist);
        simulate(flock);
        //一下观察一群绿头鸭子
        //mallardDucks.registerObserver(quackologist);
        //simulate(mallardDucks);
        System.out.println("鸭子一共叫了："+QuackCounterDecrator.getNumOfQuack()+"次");

    }
    void simulate(Quackable duck){
        duck.quack();
    }
}
