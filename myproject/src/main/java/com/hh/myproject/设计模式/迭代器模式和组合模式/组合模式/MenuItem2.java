package com.hh.myproject.设计模式.迭代器模式和组合模式.组合模式;

/**
 * @author hejiayuan
 * @create 2021-07-20-10:22
 */
public class MenuItem2 extends MenuComponent {
    private String name;
    private String desc;
    private double price;
    private boolean isVegetarain;

    public MenuItem2(String name, String desc, double price, boolean isVegetarain) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.isVegetarain = isVegetarain;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarain() {
        return isVegetarain;
    }

    @Override
    public void print() {
        System.out.print(getName()+",");
        System.out.print(getPrice()+"----");

        if(isVegetarain()){
            System.out.print("素食，");
        }
        System.out.println(getDesc());
    }
}
