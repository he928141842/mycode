package com.hh.myproject.设计模式.命令模式.厂商类;

import lombok.Data;

/**
 * @author hejiayuan
 * @create 2021-07-17-15:37
 */
@Data
public class CeilingFan {
    public static int HIGH = 3;
    public static int MID = 2;
    public static int LOW = 1;
    public static int OFF = 0;
    private String name;
    /**
     * 当前转速
     */
    private int speed;

    public CeilingFan(String name) {
        this.name = name;
        this.speed = OFF;
    }

    public void high(){
        this.speed = HIGH;
        System.out.println("电风扇快速转");
    }

    public void mid(){
        this.speed = MID;
        System.out.println("电风扇中速转");

    }
    public void low(){
        this.speed = LOW;
        System.out.println("电风扇低速转");

    }
    public void off(){
        this.speed = OFF;
        System.out.println("电风扇关闭");

    }

    public int getSpeed() {
        return speed;
    }
}
