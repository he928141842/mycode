package com.hh.myproject.设计模式.适配器模式以及外观模式.外观;

import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Amplifier;
import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Dvd;
import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Movie;
import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Popper;

/**
 * @author hejiayuan
 * @create 2021-07-18-18:05
 */
public class HomeTheaterFacade {
    //通过聚合将需要的类组合到外观类中
    Amplifier amplifier;
    Dvd dvd;
    Movie movie;
    Popper popper;

    public HomeTheaterFacade(Amplifier amplifier, Dvd dvd, Movie movie, Popper popper) {
        this.amplifier = amplifier;
        this.dvd = dvd;
        this.movie = movie;
        this.popper = popper;
    }

    public void watchMovie(){
        System.out.println("准备播放电影");
        popper.on();
        popper.pop();
        amplifier.on();
        amplifier.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie(){

    }
}
