package com.hh.myproject.设计模式.命令模式.commands;

import com.hh.myproject.设计模式.命令模式.Command;
import com.hh.myproject.设计模式.命令模式.厂商类.Light;

/**
 * @author hejiayuan
 * @create 2021-07-17-10:30
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
