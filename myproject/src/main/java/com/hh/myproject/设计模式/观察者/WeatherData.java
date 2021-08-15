package com.hh.myproject.设计模式.观察者;

import lombok.*;

import java.util.ArrayList;

/**
 * 发布者  Subject
 * @author hejiayuan
 * @date 2021-04-26 11:19
 */
@Data
@Builder  //使用此注解 支持建造者模式  会造成无空参构造方法 需要配合下面两个注解使用 或者自己写全参和无参
//@NoArgsConstructor
//@AllArgsConstructor
public class WeatherData implements Subject{
    /**
     * 保存观察者对象
     */
    private ArrayList observers ;

    /**
     * 温度数据
     */
    private float temperature;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 气压
     */
    private float pressure;

    public WeatherData(ArrayList observers, float temperature, float humidity, float pressure) {
        this.observers = observers;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public WeatherData() {
        observers = new ArrayList();
    }

    /**
     * 注册观察者方法
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * 移除观察者
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * 数据改变时 通知方法
     */
    @Override
    public void notifyObservers() {
        for (Object o : observers) {
            Observer observer = (Observer) o;
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 此方法被调用代表数据发生变化
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 具体改变数据的方法   不关心
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

    // WeatherData的其他方法


}
