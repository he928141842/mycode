package com.hh.myproject.base.工具类;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author hejiayuan
 * @create 2021-07-31-22:30
 */
public class BeanUtilsDemo {
    public static void main(String[] args) {
        //如果有嵌套别的类 因为是浅拷贝 所以嵌套的类是直接地址引用  如果修改了复制的类的嵌套类 原来的类也会变
        A a = new A();
        a.setName("1");
        a.setC(new C("tom"));

        A a1 = new A();
        BeanUtils.copyProperties(a,a1);

        B b = new B();
        BeanUtils.copyProperties(a,b);


        System.out.println(a1.getC() == a.getC());
        System.out.println(a.getC() == b.getC());

        //使用序列化 反序列化
        A a2 = JSON.parseObject(JSON.toJSONString(a), A.class);
        System.out.println(a2.getC() == a.getC());

        //hutool工具类的深拷贝  必须实现序列化接口
        A a3 = ObjectUtil.cloneByStream(a);
        System.out.println(a.getC() == a3.getC());

    }
}
@Data
class A implements Serializable {
    String name;
    C c;
}
@Data
class B {
    String name;
    C c;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class C implements Serializable{
    String name;
}