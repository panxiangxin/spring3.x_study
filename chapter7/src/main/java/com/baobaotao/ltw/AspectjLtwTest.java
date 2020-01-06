package com.baobaotao.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjLtwTest {

	public static void main(String[] args) {
		String config = "com/baobaotao/ltw/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		
		Waiter waiter = applicationContext.getBean(Waiter.class);
		waiter.greetTo("John");
		waiter.serveTo("John");
	}
}
