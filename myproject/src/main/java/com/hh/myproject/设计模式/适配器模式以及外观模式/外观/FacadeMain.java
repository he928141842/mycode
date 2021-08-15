package com.hh.myproject.设计模式.适配器模式以及外观模式.外观;

import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Amplifier;
import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Dvd;
import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Movie;
import com.hh.myproject.设计模式.适配器模式以及外观模式.外观.家庭影院类.Popper;

/**
 * @author hejiayuan
 * @create 2021-07-18-18:15
 */
public class FacadeMain {
    public static void main(String[] args) {
        /**
         * 外观模式L：提供了一个统一的接口，用来访问子系统中的一群接口。定义了一个高层接口，让子系统更容易使用
         *
         * 最少知识原则:只和你的密友对话  减少类的依赖
         * 只调用以下方法
         * 1只调用属于本身类的方法 2被当作参数传进来的对象的方法
         * 3此方法内所创建的新的实例对象的方法  4对象的任何组件（通过聚合、组合、等方式引用的实例 has a）
         *
         */

        Amplifier amplifier = new Amplifier();
        Movie movie = new Movie("铁道游击队");
        Dvd dvd = new Dvd();
        Popper popper = new Popper();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier,dvd,movie,popper);

        homeTheaterFacade.watchMovie();

    }
}
