package com.hh.myproject.设计模式.装饰者.例二;

import lombok.Data;

/**
 * @author hejiayuan
 * @date 2021-06-21 11:27
 */
@Data
public abstract class Operations {
    private int x;

    private int y;

    private Direction direction;
    /**
     * 执行方法  返回原点类（具体实现）
     * @return
     */
    public abstract Operations exec();


    // 主要是方便打印数据
    @Override
    public String toString() {
        return "坐标{" +
                "x=" + x +
                ", y=" + y +
                ", 方向=" + direction +
                '}';
    }

     public enum Direction{
        N,S,W,E
    }
}
