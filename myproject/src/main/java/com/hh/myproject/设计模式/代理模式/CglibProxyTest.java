package com.hh.myproject.设计模式.代理模式;



import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hejiayuan
 * @create 2020-06-23-21:29
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        Tom t = new Tom();
        PersonInterceptor interceptor = new PersonInterceptor();
        interceptor.bind(t);

        Tom proxy = (Tom) interceptor.getProxy();
        proxy.eat();

    }
}

/*
 * 实现接口的类可以强制使用cglib
 * */
interface Perison {
    void eat();
}

//这里不实现接口了  因为cglib采用继承实现动态代理
class Tom {


    public void eat() {
        System.out.println("Tom吃饭");
    }
}

class PersonInterceptor implements MethodInterceptor {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    //生成代理类
    public Object getProxy() {
        //增强类
        Enhancer enhancer = new Enhancer();
        //设置代理类继承的父类（被代理类）
        enhancer.setSuperclass(obj.getClass());

        //设置回调
        enhancer.setCallback(this);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //对被代理类功能的增强
        System.out.println("开启事务");
        //如果使用invoke（）方法  传入的对象必须是被代理类的实例  不然会出现错误  循环调用invoke
        // 因为https://blog.csdn.net/kingmax54212008/article/details/83902535
        //Object returnvalue = methodProxy.invoke(obj,objects);
        Object returnvalue = methodProxy.invokeSuper(o,objects);
        System.out.println("提交事务");
        return returnvalue;
    }
}
