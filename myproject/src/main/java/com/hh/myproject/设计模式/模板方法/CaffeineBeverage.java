package com.hh.myproject.设计模式.模板方法;

/**
 * @author hejiayuan
 * @create 2021-07-19-15:13
 */
public abstract class CaffeineBeverage {

    protected boolean hooking = true;

    //将喝茶和喝咖啡的准备流程在超类中定义  可以定义成final防止子类修改结构
    public final void praparedBeverage(){
        boilWater();
        brew();
        //钩子方法 让子类有能力对算法的不同节点进行挂钩
        if (hook()){
            addCondiments();
        }
        pourInCup();
    }
    //子类都具有的行为可以直接在超类中实现
    public void boilWater(){
        System.out.println("把水煮开。。");
    }
    //将咖啡 或者 茶叶导入杯中 有差别可以在子类中具体实现
    public abstract void brew();

    //添加不同的佐料
    public abstract void addCondiments();

    public void pourInCup(){
        System.out.println("将煮好的饮料倒入杯子");
    }
    //钩子方法  子类可以实现也可以不实现 给子类动态的参与流程的方法
    //通常是空方法 或者默认实现
    public boolean hook(){
        return hooking;
    }
}
