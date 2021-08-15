package com.hh.myproject.设计模式.观察者;

/**
 * 订阅接口
 * @author hejiayuan
 * @date 2021-04-26 11:22
 */
public interface Observer {
    /**
     * 观察者实现  用来更新自己订阅内容的 变化
     * @param temp
     * @param humidity
     * @param pressure
     */
     void update(float temp, float humidity, float pressure);

}
