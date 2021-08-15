package com.hh.myproject;

import com.hh.myproject.controller.MyController;
import com.hh.myproject.dao.TestDao;
import com.hh.myproject.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class MyprojectApplicationTests {

    @Autowired
    MyController testDao;
    @Autowired
    TestService testService;
    @Test
    void contextLoads() {
        System.out.println(testDao.getInfo("1"));
    }

    /**
     * 测试事务失效
     * 问题1  A类调用B类方法插入数据库  B类方法使用required_new  A类有事务控制，运行B类方法时会暂时挂起当前事务，且外部事务
     *        的异常不会影响内部事务的提交。
     * 问题2  A类1方法调用A类2方法插入数据库  A类2方法使用required_new  猜测 A类有事务控制，运行A类插入数据库方法时会暂时挂起当前事务，且外部事务
     *       的异常不会影响内部事务的提交。   实际：A类外部事务的方法出现异常时影响了内部事务的提交。
     *       问题2事务失效问题   2方法transactional 实际上失效了  原因可能是代理对象  在一个Service内部，事务方法之间的嵌套调用，普通方法和事务方法之间的嵌套调用，
     *       都不会开启新的事务.是因为spring采用动态代理机制来实现事务控制，而动态代理最终都是要调用原始对象的，而原始对象在去调用方法时，是不会再触发代理了
     *       理解：通过aop动态代理对象调用原来对象的方法a  可能在调用原来对象的方法a前通过编程式事务 开启事务 调用a后提交事务 （https://chenchenchen.blog.csdn.net/article/details/106287956?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2.control）
     *             但是，如果a方法还调用了原来对象的b方法，此时由于不会重新生成代理对象。所以transatioanl注解失效  自然不会开启新事务 或者提交事务。b方法等于没加事务控制
     *       解决方法 参考 https://blog.csdn.net/m0_38027656/article/details/84190949
     *               或者在a方法调用b方法时，通过applicationcontext获取此对象实例去调用（此时获取的是代理对象），或者autowired注入自己  或者 用上面链接中的方法获取代理对象
     *     Test类中 A方法调用 同一类的B方法 过程
     *     生成代理对象 Test@11  此对象的A方法如果有声明式事务 @Transactional  则使用的是CglibMethodInvocation 的proceed方法
     *     其中有获取不同类型的 TransactionManager的过程  如果A方法没有 @Transactional注解则使用的是 methodProxy.invoke() 没有进行事务控制
     *     A方法代理以后可能是这样  A有事务控制（通过TransactionInterceptor 进行拦截，判断有没有加注解）
     *                            编程式事务  设置自动提交autoCommit=false => 开启事务 => A  方法 执行 => B方法执行  =>  提交（或发生异常回滚）
     *         A无事务控制  代理对象执行A方法（没有加注解） => 执行B方法  可以看到  是没有开启事务控制的  无论B有没有加事务控制B方法执行的时候都不带事务
     *
     *     如何解决：无论上述解决方法如何  核心都是通过  A执行完之后 => 通过各种方法获取代理对象  通过代理对象调用 B方法
     *     为什么能解决？ 在代理对象调用B时，此时会判断B方法上的@transactional注解  而不是未解决之前那种 只判断 A对象的@transactional注解
     *
     */
    @Test
    public void test22(){
        testService.testTransactional();

    }

    @Test
    public void test23(){
        //接口的default方法
        testService.deafaultMethod();
        //接口的static方法
        TestService.default2method();

    }

}
