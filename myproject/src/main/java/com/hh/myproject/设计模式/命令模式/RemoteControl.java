package com.hh.myproject.设计模式.命令模式;

import com.hh.myproject.设计模式.命令模式.commands.NoCommand;

/**
 * @author hejiayuan
 * @create 2021-07-17-11:36
 */
public class RemoteControl {
    /**
     * 遥控器的打开命令 可能有多个开按钮 数组记录对应位置的按钮功能
     */
    private Command[] onCommands;

    /**
     * 遥控器的关闭命令
     */
    private Command[] offCommands;

    private Command undoCommand;

    public RemoteControl() {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];
        //初始化为无命令
        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < onCommands.length; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;

    }

    /**
     * 对应遥控器按钮位置设置命令
     *
     * @param slot
     * @param onCommand
     * @param offCommand
     */
    public void setCommands(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    /**
     * 对应位置的打开命令执行 不需要知道具体是哪个命令对象执行
     *
     * @param slot
     */
    public void onButtonWasPushed(int slot) {
        onCommands[slot].excute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].excute();
        undoCommand = offCommands[slot];
    }

    /**
     * 撤回按钮
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n---Remote control-----\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("slot[" + i + "]," + onCommands[i].getClass().getName() + "  " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
}
