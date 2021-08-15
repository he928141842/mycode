package com.hh.myproject.设计模式.观察者;

/**
 * 发布接口
 * @author hejiayuan
 * @date 2021-04-26 11:22
 */
public interface Subject {
    /**
     * 提供的注册接口  将自己注册成为观察者
     * @param observer
     */
    void  registerObserver(Observer observer);

    /**
     * 提供的取消订阅 接口  将自己从观察队列中移除
     * @param observer
     */
    void  removeObserver(Observer observer);

    /**
     * 通知接口  发布者实时通知订阅者
     */
    void  notifyObservers();
}
