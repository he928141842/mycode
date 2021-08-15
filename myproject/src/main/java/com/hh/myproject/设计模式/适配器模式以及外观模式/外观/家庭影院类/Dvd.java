package com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类;

/**
 * @author hejiayuan
 * @create 2021-07-18-18:09
 */
public class Dvd {


    public void on(){
        System.out.println("打开dvd");
    }

    public void play(Movie movie){
        System.out.println("播放电影:"+movie.getName());
    }
}
