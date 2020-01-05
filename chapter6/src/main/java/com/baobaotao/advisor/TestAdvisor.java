package com.baobaotao.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAdvisor {
	public static void main(String[] args) {
		
		String config = "com/baobaotao/advisor/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		
//		Waiter waiter = applicationContext.getBean("waiter",Waiter.class);
//		Seller seller = applicationContext.getBean("seller",Seller.class);
//		
//		waiter.greetTo("John");
//		waiter.serveTo("John");
//		
//		seller.greetTo("Tom");
		
		Waiter waiter = applicationContext.getBean("waiter3",Waiter.class);
		WaiterDelegate waiterDelegate = new WaiterDelegate();
		waiterDelegate.setWaiter(waiter);
		waiter.greetTo("Peter");
		waiter.serveTo("Peter");
		waiterDelegate.service("Peter");
	}
}
