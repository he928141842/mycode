package com.hh.myproject.base;

/**
 * @author hejiayuan
 * @date 2021-01-21 14:38
 */
public class ConstantPoolTest {
    public static void main(String[] args) {
        objPoolTest();
    }

    public static void objPoolTest() {
        //http://www.cnblogs.com/DreamSea/archive/2011/11/20/2256396.html

        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2\t" + (i1 == i2));//true  -127 - 128已经缓存在IntegerCache.cache数组中  直接赋值等于 调用Interge.valueOf()会从中取  所以地址相等
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3)); //对象拆箱  纯数学运算  true
        System.out.println("i4=i5\t" + (i4 == i5));// false  比较的地址不一样
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));//拆箱操作  数学运算  true

        System.out.println();
    }
}
