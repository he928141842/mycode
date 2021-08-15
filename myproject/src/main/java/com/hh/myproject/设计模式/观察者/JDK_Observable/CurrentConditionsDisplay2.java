package com.hh.myproject.设计模式.观察者.JDK_Observable;

import com.hh.myproject.设计模式.观察者.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author hejiayuan
 * @date 2021-04-26 16:04
 */
public class CurrentConditionsDisplay2 implements Observer, DisplayElement {
    //发布者对象 用来订阅 以及获取数据
    private Observable observable;

    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temperature = weatherData2.getTemperature();
            this.humidity = weatherData2.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
