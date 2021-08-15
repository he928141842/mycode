package com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类;

/**
 * @author hejiayuan
 * @create 2021-07-18-18:05
 */
public class Amplifier {

    public void on(){
        System.out.println("打开功放");
    }

    public void setVolume(int volume){
        System.out.println("设置音量为："+volume);
    }
}
