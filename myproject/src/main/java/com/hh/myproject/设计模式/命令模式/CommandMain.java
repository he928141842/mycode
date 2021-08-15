package com.hh.myproject.设计模式.命令模式;

import com.hh.myproject.设计模式.命令模式.commands.*;
import com.hh.myproject.设计模式.命令模式.厂商类.CeilingFan;
import com.hh.myproject.设计模式.命令模式.厂商类.Light;

/**
 * @author hejiayuan
 * @create 2021-07-17-10:21
 */
public class CommandMain {
    /**
     * 命令模式：将动作的请求者从动作的执行者中解耦 将请求封装成对象，以便使用不同的请求、队列、或者日志来参数化其他对象。
     *          命令模式也支持撤销操作。
     *  如 遥控器就是动作的请求者  灯类就是动作的执行者
     *      遥控器不需要知道最终是谁执行 只需要按下对应按钮
     *
     *  这种将执行者和进行计算的对象解耦出来的思想应用在线程池执行 Runnable(Command)的时候 各个线程不需要知道具体是什么内容
     *  可能上一秒还在进行财务运算 下一秒就进行数学运算  他只是调用run方法
     *
     *  也可以应用在需要undo的场景中 比如日志回滚
     *
     *  命令模式在spring中的应用 jdbcTemplate的query方法等
     *  其中jdbctemplate相当于RemoteControl的角色 命令调用者
     *  PreparedStatementCallback相当于Command接口 定义了doInPreparedStatement方法
     *  而其具体实现也由匿名内部类代替（不需要单独写出来）
     *  jdbcTemplate中的query方法 其中excute的第二个参数就是Command的具体实现
     *  而且它也不需要命令的具体执行者 如Light 直接在Command的具体实现中写了
     *  execute(psc, new PreparedStatementCallback<T>() {
     *                        @Override
     *            @Nullable
     *            public T doInPreparedStatement(PreparedStatement ps) throws SQLException {
     * 				ResultSet rs = null;
     * 				try {
     * 					if (pss != null) {
     * 						pss.setValues(ps);
     *                    }
     * 					rs = ps.executeQuery();
     * 					return rse.extractData(rs);
     *                }
     * 				finally {
     * 					JdbcUtils.closeResultSet(rs);
     * 					if (pss instanceof ParameterDisposer) {
     * 						((ParameterDisposer) pss).cleanupParameters();
     *                    }
     *                }
     *            }        * 		});
     *
     *  在命令执行者中直接执行PreparedStatementCallback的doInpreparedStatement方法
     *
     *public <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action)
     * 			throws DataAccessException {
     *
     * 			T result = action.doInPreparedStatement(ps);
     *
     * 			return result;
     *}
     * @param args
     */
    public static void main(String[] args) {
        Light light = new Light();
        CeilingFan ceilingFan = new CeilingFan("客厅的电风扇");
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        Command highFan = new CeilingFanHighCommand(ceilingFan);
        Command midFan = new CeilingFanMidCommand(ceilingFan);
        Command lowFan = new CeilingFanLowCommand(ceilingFan);
        Command offFan = new CeilingFanOffCommand(ceilingFan);

        //SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        //simpleRemoteControl.setCommand(lightOn);
        //simpleRemoteControl.buttonWasPressed();
        //
        //simpleRemoteControl.setCommand(lightOff);
        //simpleRemoteControl.buttonWasPressed();

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommands(0,lightOn,lightOff);
        remoteControl.setCommands(1,lightOn,lightOff);
        System.out.println(remoteControl);

        //remoteControl.onButtonWasPushed(0);
        //remoteControl.undoButtonWasPushed();

        remoteControl.setCommands(1,highFan,offFan);
        remoteControl.setCommands(2,midFan,offFan);

        //remoteControl.onButtonWasPushed(1);
        //remoteControl.offButtonWasPushed(1);
        //remoteControl.undoButtonWasPushed();
        Command[] onMacroCommands = {lightOn,highFan};
        Command[] offMacroCommands = {lightOff,offFan};
        MacroCommand onMacroCommand = new MacroCommand(onMacroCommands);
        MacroCommand offMacroCommand = new MacroCommand(offMacroCommands);

        remoteControl.setCommands(3,onMacroCommand,offMacroCommand);
        remoteControl.onButtonWasPushed(3);
        remoteControl.undoButtonWasPushed();

    }
}
