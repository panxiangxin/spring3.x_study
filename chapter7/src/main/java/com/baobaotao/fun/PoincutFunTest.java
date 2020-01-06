package com.baobaotao.fun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.Waiter;


public class PoincutFunTest {

	public static void main(String[] args) {
		String config = "com/baobaotao/fun/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		
		Waiter naiveWaiter = (Waiter)applicationContext.getBean("naiveWaiter");
		Waiter naughtyWaiter = (Waiter)applicationContext.getBean("naughtyWaiter");
		
		naiveWaiter.greetTo("John");
		naughtyWaiter.greetTo("John");
	}
}
