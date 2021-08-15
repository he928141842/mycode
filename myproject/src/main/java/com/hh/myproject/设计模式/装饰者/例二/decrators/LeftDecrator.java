package com.hh.myproject.设计模式.装饰者.例二.decrators;

import com.hh.myproject.设计模式.装饰者.例二.Operations;
import lombok.Data;

/**
 * @author hejiayuan
 * @date 2021-06-21 14:01
 */
@Data
public class LeftDecrator extends Operations {
    //用于获取被包装类
    private Operations operations;

    public LeftDecrator(Operations operations){
        //首先执行上一个被包装类得 方法
        this.operations = operations.exec();
    }

    @Override
    public Operations exec() {
        switch (operations.getDirection()){
            case E:
                operations.setDirection(Direction.N);
                break;
            case W:
                operations.setDirection(Direction.S);
                break;
            case N:
                operations.setDirection(Direction.W);
                break;
            case S:
                operations.setDirection(Direction.E);
                break;
            default:
                break;
        }

        return this.operations;
    }
}
