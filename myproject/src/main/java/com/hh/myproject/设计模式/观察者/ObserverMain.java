package com.hh.myproject.设计模式.观察者;

import com.hh.myproject.设计模式.观察者.Observers.CurrentConditionsDisplay;

/**
 * @author hejiayuan
 * @date 2021-04-26 14:22
 */
public class ObserverMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Observer observer = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);




    }
}
