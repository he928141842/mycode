package com.hh.myproject.设计模式.复合模式.鸭子类;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.观察者.DuckObserver;
import com.hh.myproject.设计模式.复合模式.观察者.Observerble;

/**鸭鸣器
 * @author hejiayuan
 * @create 2021-07-21-19:36
 */
public class DuckCall implements Quackable {
    String name;
    Observerble observerble;

    public DuckCall() {
        this.observerble = new Observerble(this);
        this.name = "我是鸭鸣器";
    }

    @Override
    public void quack() {
        System.out.println("鸭鸣器在叫");
        //叫的时候通知观察者们
        notifyObservers();
    }

    @Override
    public void registerObserver(DuckObserver observer) {
        observerble.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observerble.notifyObservers();
    }
}
