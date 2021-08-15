package com.hh.myproject.设计模式.装饰者.例二.decrated;

import com.hh.myproject.设计模式.装饰者.例二.Operations;

/**
 * @author hejiayuan
 * @date 2021-06-21 14:01
 */
public  class Locations extends Operations {

    public Locations(int x,int y,Direction direction) {
        this.setX(x);
        this.setY(y);
        this.setDirection(direction);
    }

    @Override
    public Operations exec() {
        return this;
    }
}
