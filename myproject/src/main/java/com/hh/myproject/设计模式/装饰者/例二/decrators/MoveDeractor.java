package com.hh.myproject.设计模式.装饰者.例二.decrators;

import com.hh.myproject.设计模式.装饰者.例二.Operations;
import lombok.Data;

/**
 * @author hejiayuan
 * @date 2021-06-21 14:31
 */
@Data
public class MoveDeractor extends Operations {
    private Operations operations;

    public MoveDeractor(Operations operations) {
        this.operations = operations.exec();
    }

    @Override
    public Operations exec() {
        int x = operations.getX();
        int y = operations.getY();
        switch (operations.getDirection()){
            case E:

                operations.setX(++x);
                break;
            case W:

                operations.setX(--x);
                break;
            case N:
                int c = y+1;
                operations.setY(++y);
                break;
            case S:
                int d = y-1;
                operations.setY(--y);
                break;
            default:
                break;
        }

        return this.operations;
    }
}
