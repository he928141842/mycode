package com.hh.myproject.base.spring.循环依赖.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hejiayuan
 * @create 2021-07-29-21:42
 */
@Component
public class Person {
    @Autowired
    Tom tom;


    /**
     * 让这个person类需要afterInializationPostProcessor生成代理对象，但是循环依赖发生在populateBean时
     *  而生成代理对象在下一步的initializeBean()中的applyBeanPostProcessorsAfterInitialization()方法
     *  这样是在循环依赖中给它的objectFactory是怎么返回当前半成品代理类的呢？还是说现在Tom依赖的类就只是普通的Person引用
     *  到下一步就自然变成aop代理的对象了呢？（这种可能性比较大 错了）如果有其他的属性需要注入并且不需要代理类可能是这样的，开启了事务管理器的话（需要代理）
     *  目前看是通过InfrastructureAdvisorAutoProxyCreator（SmartInstantiationAwareBeanPostProcessor的子类）去调用他的
     *  wrapIfNecessary()方法去生成了BeanFactoryTransactionAttributeSourceAdvisor并且生成了基于cglib的代理对象（如果person对象有事务方法的话）Person
     *  疑问？那这样不就跟原来的person类不一样了吗？person.png说明了就是不一样。看他接下来做了什么
     *  初始化方法完成后，在docreateBean方法的606行Object earlySingletonReference = getSingleton(beanName, false);
     *  又从新调用了一次getSingleton方法，这个时候earlySingletonObjects（俗称三级缓存我觉得叫二级缓存更贴切）中是放了当初从二级缓存（我觉得叫三级更贴切）singletonFactories得到的代理对象person的
     *  这个时候取出来就替换了原本的普通person了
     *  最后调用addSingleton将他加入了singletonObjects单例池中，并再此将三级缓存的person移除
     *
     *  为什么需要earlySingleTonobjects呢？看着好像只需要singletonFactories和singletonObjects就行？
     *  https://www.cnblogs.com/semi-sub/p/13548479.html
     *  因为如果这个对象是需要被代理的话，每次调用singlrtonFactories中的beanFactory的getObject方法都会产生一个新的代理类，不如将它放到earlySingletonObjets中去取
     *
     *  那为什么不一开始直接将半成品对象放到earlySingleTonobjects中，要放到singletonFactories中一个objectFactory呢？
     *  因为在objectFactory的方法中我们可以看到，它不仅是只返回保存的半成品对象，可能在它执行执行了一些后置处理器，生成代理对象替换原来的半成品
     *  如果只存这个半成品，不符合要求，也是为了方便我们扩展
     *
     *  */
    //@Transactional
    //public void transaction(){
    //
    //}
}
