package com.hh.myproject.设计模式.命令模式.commands;

import com.hh.myproject.设计模式.命令模式.Command;
import com.hh.myproject.设计模式.命令模式.厂商类.Light;

/**
 * @author hejiayuan
 * @create 2021-07-17-10:31
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
