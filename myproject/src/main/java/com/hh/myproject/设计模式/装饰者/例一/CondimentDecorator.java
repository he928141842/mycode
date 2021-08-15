package com.hh.myproject.设计模式.装饰者.例一;

/**
 * 装饰者抽象类  同样要继承 Beverage类  为了使 调料类（此类的子类） 和具体的饮料类型匹配（包装以后代替饮料类型使用）
 * @author hejiayuan
 * @date 2021-06-16 15:39
 */
public abstract class CondimentDecorator extends Beverage{
    @Override
    public abstract String getDesc();
}
