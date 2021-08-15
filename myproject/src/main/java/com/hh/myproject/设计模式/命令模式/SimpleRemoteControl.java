package com.hh.myproject.设计模式.命令模式;

/**
 * @author hejiayuan
 * @create 2021-07-17-10:32
 */
public class SimpleRemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed(){
        command.excute();
    }

}
