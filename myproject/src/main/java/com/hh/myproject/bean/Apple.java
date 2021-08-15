package com.hh.myproject.bean;

import lombok.Data;

/**
 * @author hejiayuan
 * @date 2020-12-14 16:58
 */
@Data
public class Apple {
    private String color;
    private Integer weight;

    public Apple() {
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

}
