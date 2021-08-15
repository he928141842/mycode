package com.hh.myproject.设计模式.命令模式.commands;

import com.hh.myproject.设计模式.命令模式.Command;

/**
 * @author hejiayuan
 * @create 2021-07-17-11:39
 */
public class NoCommand implements Command {
    @Override
    public void excute() {
        System.out.println("暂无功能绑定");
    }

    @Override
    public void undo() {
        System.out.println("暂无功能绑定");
    }
}
