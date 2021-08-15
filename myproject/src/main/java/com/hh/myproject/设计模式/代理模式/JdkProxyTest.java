package com.hh.myproject.设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hejiayuan
 * @create 2020-06-21-22:03
 */

/*
 *   动态代理
 *       想实现动态代理需要解决的问题
 *          1。如何根据加载到内存中的被代理类 动态的创建一个代理类及其对象
 *          2. 当通过代理类的对象调用方法时 如何动态的去调用被代理类中的同名方法
 *
 * */
public class JdkProxyTest {
    public static void main(String[] args) {
        Lining l = new Lining();

        ClothFact proxy = (ClothFact) ProxyFact.getProxyInstance(l);
        proxy.produce();

        //使用动态代理代替静态代理  例子
        Nike nike = new Nike();

        ClothFactory proxyInstance = (ClothFactory) ProxyFact.getProxyInstance(nike);
        proxyInstance.produce();

        //直接写
        ClothFactory o = (ClothFactory) Proxy.newProxyInstance(nike.getClass().getClassLoader(),
                nike.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(nike, args);
                    }
                });

        o.produce();

    }
}

interface ClothFact {
    public void produce();
}

class Lining implements ClothFact {


    @Override
    public void produce() {
        System.out.println("生产lining");
    }
}

class ProxyFact {

    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;//赋值时需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法 incoke（）
    //将被代理类要执行的方法a的功能声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method 即为代理类对象调用的方法 此方法作为了被代理类调用的方法
        //obj被代理类的对象  返回值作为当前类中的invoke方法的返回值
        return method.invoke(obj, args);
    }
}