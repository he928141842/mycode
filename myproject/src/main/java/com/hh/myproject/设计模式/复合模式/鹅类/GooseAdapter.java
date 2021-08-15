package com.hh.myproject.设计模式.复合模式.鹅类;

import com.hh.myproject.设计模式.复合模式.Quackable;
import com.hh.myproject.设计模式.复合模式.观察者.DuckObserver;
import com.hh.myproject.设计模式.复合模式.观察者.Observerble;

/**
 * 鹅的适配器，我们想要在所有使用鸭子的地方同样使用老鹅 毕竟差不多
 * 适配器类也需要实现被适配者实现的接口
 * 并且通过组合来获得老鹅
 * @author hejiayuan
 * @create 2021-07-21-19:43
 */
public class GooseAdapter implements Quackable {
    Goose goose;
    Observerble observerble;
    public GooseAdapter(Goose goose) {
        this.observerble = new Observerble(this);
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.hook();
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
