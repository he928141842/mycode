package com.hh.myproject.base;

import com.hh.myproject.bean.Apple;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hejiayuan
 * @date 2020-12-14 17:00
 */
public class CollectorsTest {

    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("red", 170), new Apple("green", 100), new Apple("red", 170),
            new Apple("yellow", 170), new Apple("green", 150));

    /**
      * @author hejiayuan
    　* @Description: 测试java8的collectors类
    　* @date 2020/12/14 17:00
      * @param
    　**/
    public static void main(String[] args) {
        //1、一般写法
        Map<String,List<Apple>> backet = new HashMap<>();
//        for (Apple apple :orchard) {
//            List<Apple> tmp = new ArrayList<>();
//            tmp.add(apple);
//            if (backet.containsKey(apple.getColor())){
//                tmp.addAll(backet.get(apple.getColor()));
//            }
//            backet.put(apple.getColor(),tmp);
//        }
//
//        backet.forEach((i1,i2)->{
//            System.out.print(i1);
//            System.out.println(i2);
//        });


        //2、java8写法  optinaol
//        orchard.forEach(apple -> {
//            List<Apple> backts = Optional.ofNullable(backet.get(apple.getColor())).orElseGet(()->{
//                List<Apple> tmp = new ArrayList<>();
//                tmp.add(apple);
//                return tmp;
//            });
//            backts.add(apple);
//        });

        //3.Collector改进
        Map<String, List<Apple>> collect = orchard.stream().collect(Collectors.groupingBy(Apple::getColor));

        collect.forEach((i1,i2)->{
            System.out.println(i1);
            System.out.println(i2);
        });


    }
}
