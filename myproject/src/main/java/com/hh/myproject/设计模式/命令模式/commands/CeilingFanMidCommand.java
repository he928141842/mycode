package com.hh.myproject.设计模式.命令模式.commands;

import com.hh.myproject.设计模式.命令模式.Command;
import com.hh.myproject.设计模式.命令模式.厂商类.CeilingFan;

/**
 * @author hejiayuan
 * @create 2021-07-17-15:43
 */
public class CeilingFanMidCommand implements Command {
    private CeilingFan ceilingFan;
    //之前的挡位
    private int preSpeed;

    public CeilingFanMidCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void excute() {
        preSpeed = ceilingFan.getSpeed();
        ceilingFan.mid();
    }

    @Override
    public void undo() {
        if (preSpeed == CeilingFan.HIGH){
            ceilingFan.high();
        }else if (preSpeed == CeilingFan.MID){
            ceilingFan.mid();
        }else if (preSpeed == CeilingFan.LOW){
            ceilingFan.low();
        }else {
            ceilingFan.off();
        }
    }
}
