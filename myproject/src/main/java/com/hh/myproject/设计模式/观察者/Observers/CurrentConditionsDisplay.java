package com.hh.myproject.设计模式.观察者.Observers;

import com.hh.myproject.设计模式.观察者.DisplayElement;
import com.hh.myproject.设计模式.观察者.Observer;
import com.hh.myproject.设计模式.观察者.Subject;

/**
 * @author hejiayuan
 * @date 2021-04-26 11:42
 */
public class CurrentConditionsDisplay  implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    /**
     * 发布者对象 通过构造函数赋值  注册自己为观察者 也可能想要取消注册
     */
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {

        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    /**
     * 将变化后的值 更新  然后调用 display方法
     * @param temperature
     * @param humidity
     * @param pressure
     */
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
