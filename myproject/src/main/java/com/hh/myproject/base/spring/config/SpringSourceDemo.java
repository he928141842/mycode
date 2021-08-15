package com.hh.myproject.base.spring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** spring容器的创建流程
 * @author hejiayuan
 * @create 2021-07-29-19:50
 */
public class SpringSourceDemo {
    public static void main(String[] args) {
        /**
         *  SpringSource.txt spring容器创建流程
         */
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        /**
         * public void refresh() throws BeansException, IllegalStateException {
         * 		synchronized (this.startupShutdownMonitor) {
         * 			// Prepare this context for refreshing.准备刷新上下文
         * 			prepareRefresh();
         *
         * 			// Tell the subclass to refresh the internal bean factory.
         * 		   刷新BeanFactory并且返回DefaultListableBeanFactory 此时上下文中的属性都是默认值
         * 			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
         *
         * 			// Prepare the bean factory for use in this context.
         * 		   给上下文中注册一些可用的组件，设置一些默认值
         * 			prepareBeanFactory(beanFactory);
         *
         * 			try {
         * 				// Allows post-processing of the bean factory in context subclasses.
         * 			    BeanFactory准备工作完成后进行的后置处理工作；
         *          	子类通过重写这个方法来在BeanFactory创建并预准备完成以后做进一步的设置
         *             	模板方法模式的钩子方法
         * 				postProcessBeanFactory(beanFactory);
         *
         * 				// Invoke factory processors registered as beans in the context.
         * 			    在beanFactory标准初始化之后执行beanFActoryPostProcessor中的有关方法
         * 				invokeBeanFactoryPostProcessors(beanFactory);
         *
         * 				// Register bean processors that intercept bean creation.
         * 			   注册BeanPostProcessor的实现类们，主要用来在bean的生创建过程中做事，有很多实现以及子类
         * 			    功能并不相同
         * 			        DestructionAwareBeanPostProcessor、
         * 		            InstantiationAwareBeanPostProcessor、
         * 		            SmartInstantiationAwareBeanPostProcessor、
         * 		            MergedBeanDefinitionPostProcessor【internalPostProcessors】
         * 				registerBeanPostProcessors(beanFactory);
         *
         * 				// Initialize message source for this context.
         * 			    国际化有关的一些配置
         * 				initMessageSource();
         *
         * 				// Initialize event multicaster for this context.
         * 			    初始化 ApplicationEventMulticaster。
         * 			    * 如果上下文中没有定义，则使用 SimpleApplicationEventMulticaster
         * 			    将创建的ApplicationEventMulticaster添加到BeanFactory中，以后其他组件直接自动注入
         * 				initApplicationEventMulticaster();
         *
         * 				// Initialize other special beans in specific context subclasses.
         * 			   模板方法模式中的钩子方法，留给子类实现，用来在刷新容器时的回调
         * 				onRefresh();
         *
         * 				// Check for listener beans and register them.
         * 			    观察者模式（spring的事件机制），拿到所有的Applicationlistner监听器，并将它们注册到广播器中
         * 			    发布一些早期的事件
         * 				registerListeners();
         *
         * 				// Instantiate all remaining (non-lazy-init) singletons.
         * 			   创建所有的剩下的单例并且非懒加载的bean  在springSource。txt中详细
         * 				finishBeanFactoryInitialization(beanFactory);
         *
         * 				// Last step: publish corresponding event.
         * 				finishRefresh();
         *                        }
         *
         * 			catch (BeansException ex) {
         * 				if (logger.isWarnEnabled()) {
         * 					logger.warn("Exception encountered during context initialization - " +
         * 							"cancelling refresh attempt: " + ex);
         *                }
         *
         * 				// Destroy already created singletons to avoid dangling resources.
         * 				destroyBeans();
         *
         * 				// Reset 'active' flag.
         * 				cancelRefresh(ex);
         *
         * 				// Propagate exception to caller.
         * 				throw ex;
         *            }
         *
         * 			finally {
         * 				// Reset common introspection caches in Spring's core, since we
         * 				// might not ever need metadata for singleton beans anymore...
         * 				resetCommonCaches();
         *            }* 		}
         * 	}
         */
    }


}
