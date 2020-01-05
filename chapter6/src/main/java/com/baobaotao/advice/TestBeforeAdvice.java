package com.baobaotao.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeforeAdvice {
	
	public static void main(String[] args) throws Exception {
		
//		Waiter targetWaiter = new NaiveWaiter();
//		
//		BeforeAdvice advice = new GreetingBeforeAdvice();
//		
//		ProxyFactory proxyFactory = new ProxyFactory();
//		
//		proxyFactory.setTarget(targetWaiter);
//		
//		proxyFactory.addAdvice(advice);
//		
//		Waiter waiter = (Waiter)proxyFactory.getProxy();
//		
//		waiter.greetTo("John");
//		waiter.serveTo("Tom");
		
		String config = "com/baobaotao/advice/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
//		Waiter waiter = (Waiter)applicationContext.getBean("waiter");
//		waiter.greetTo("John");
		ForumService forumService = (ForumService)applicationContext.getBean("forumService");
//		forumService.removeForum(50);
		forumService.updateForum(new Forum());
	}
}
