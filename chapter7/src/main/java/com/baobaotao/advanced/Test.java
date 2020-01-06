package com.baobaotao.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.NaiveWaiter;
import com.baobaotao.Waiter;


public class Test {

	public static void main(String[] args) {
		String config = "com/baobaotao/advanced/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		Waiter waiter = (Waiter)applicationContext.getBean("naiveWaiter");
		((NaiveWaiter)waiter).greetTo("John");
		
//		NaiveWaiter naiveWaiter =(NaiveWaiter)applicationContext.getBean("naiveWaiter");
//		naiveWaiter.smile("John", 12);
		
		
		
	}
}
