package com.hh.myproject.设计模式.装饰者.例二;

import com.hh.myproject.设计模式.装饰者.例二.decrated.Locations;
import com.hh.myproject.设计模式.装饰者.例二.decrators.LeftDecrator;
import com.hh.myproject.设计模式.装饰者.例二.decrators.MoveDeractor;
import com.hh.myproject.设计模式.装饰者.例二.decrators.RightDecrator;

/**
 * @author hejiayuan
 * @date 2021-06-21 11:19
 */
public class DecorateMain2 {

    /**
     * 一队机器人漫游车将被美国宇航局降落在火星高原上。漫游车将在这个奇怪的长方形高原上巡游，以便他们的机载摄像头可以获得周围地形的完整视图，并将其发送回地球。漫游者的坐标和位置由x和y坐标的组合以及代表四个方向（E, S, W, N）的字母表示。高原划分为网格以简化导航。比如位置0，0，N，表示漫游车位于左下角并面向北。为了控制漫游车，美国宇航局发送一串简单的字母。指令字母是’L’，’R’和’M’。 ‘L’和’R’使漫游车分别向左或向右旋转90度，而不会从当前地点移动。 ‘M’表示前进一个网格点，并保持相同的方向。
     * 假设从（x，y）直接向北移动，就到了（x，y + 1）。
     *
     * INPUT：
     *
     * 第一行输入是平台的右上角坐标，左下角坐标被假定为0,0。
     * 其余的输入是有关已部署的漫游车的信息。每个漫游车都有两行输入。第一行给出了漫游车的位置，第二行是告诉漫游车如何探索高原的一系列指令。位置由两个整数和一个由空格分隔的字母组成，对应于x和y坐标以及漫游车当前的方向。
     * 每个漫游车将按顺序完成，这意味着第二个漫游车在第一个漫游车完成移动之前不会开始移动。
     * 输入：
     * 5 5
     * 1 2 N
     * LMLMLMLMM
     * 3 3 E
     * MMRMMRMRRM
     * 预期产出：
     * 1 3 N
     * 5 1 E
     * 由于这里只考虑怎么实现,所以就不写那些简单的输入提示了,我直接使用变量代替.
     * @param args
     */
    public static void main(String[] args) throws IllegalAccessException {
        //更像是命令模式

        // 定义命令
        String command1 = "LMLMLMLMM";
        Operations operations = new Locations(1,2, Operations.Direction.N);

        System.out.printf(String.format("经过命令%s后移动到%s%n",command1,runCommands(command1,operations).exec()));

//        String command2 = "MMRMMRMRRM";
//        Operations initOpera2 = new Locations(3, 3, Operations.Direction.E);
//        System.out.println(String.format("经过命令%s后移动到%s",command2,runCommands(command2,initOpera2).exec()));

    }

    public static Operations runCommands(String command,Operations operations) throws IllegalAccessException {
        for (char cmd: command.toCharArray()){
            switch (cmd) {
                case 'L':
                    operations = new LeftDecrator(operations);

                    break;
                case 'R':
                    operations = new RightDecrator(operations);

                    break;
                case 'M':
                    operations = new MoveDeractor(operations);

                    break;
                default:
                    throw new IllegalAccessException("未知命令");

            }

        }
        return operations;
    }
}
