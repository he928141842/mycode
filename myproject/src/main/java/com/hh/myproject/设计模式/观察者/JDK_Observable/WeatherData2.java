package com.hh.myproject.设计模式.观察者.JDK_Observable;

import lombok.Data;

import java.util.Observable;

/**
 * 使用jdk自带的Observable 类 Observe 接口 实现观察者模式
 * @author hejiayuan
 * @date 2021-04-26 15:58
 */
@Data
public class WeatherData2 extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    /**
     * 我们的构造器不再需要为了
     * 记住观察者们而建立数据结
     * 构了
     */
    public WeatherData2() {
    }

    /**
     * 在调用notifuObservers()之前，要先调
     * 用setChanged()来指示状态已经改变
     */
    public void measurementsChanged() {
        setChanged();
        //注意：我们没有调用
        //notifyObservers()传送数据对
        //象，这表示我们采用的做法
        //是“拉”  也就是 观察者使用getter方法获取自己需要的数据
        notifyObservers();
    }

    /**
     * 数据变更了
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    /**
     * 这些并不是新方法，只是因为我们
     * 要使用“拉”的做法，所以才提醒
     * 你有这些方法。察者会利用这些方
     * 法取得WeatherData对象的状态
     * @return
     */
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
