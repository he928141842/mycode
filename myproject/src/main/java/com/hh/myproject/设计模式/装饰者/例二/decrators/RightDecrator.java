package com.hh.myproject.设计模式.装饰者.例二.decrators;

import com.hh.myproject.设计模式.装饰者.例二.Operations;
import lombok.Data;

/**
 * @author hejiayuan
 * @date 2021-06-21 14:28
 */
@Data
public class RightDecrator extends Operations {
    private Operations operations;

    public RightDecrator(Operations operations) {
        this.operations = operations.exec();
    }

    @Override
    public Operations exec() {
        switch (operations.getDirection()){
            case E:
                operations.setDirection(Direction.S);
                break;
            case W:
                operations.setDirection(Direction.N);
                break;
            case N:
                operations.setDirection(Direction.E);
                break;
            case S:
                operations.setDirection(Direction.W);
                break;
            default:
                break;
        }
        return this.operations;
    }
}
