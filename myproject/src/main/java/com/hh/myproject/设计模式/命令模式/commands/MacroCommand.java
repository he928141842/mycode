package com.hh.myproject.设计模式.命令模式.commands;

import com.hh.myproject.设计模式.命令模式.Command;

/** 宏操作 一键启动多个命令
 * @author hejiayuan
 * @create 2021-07-17-16:03
 */
public class MacroCommand implements Command {
    private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void excute() {
        for (Command command : commands) {
            command.excute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
