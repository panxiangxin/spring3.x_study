package com.baobaotao.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.Seller;
import com.baobaotao.Waiter;


public class DeclaredParentsTest {

	public static void main(String[] args) {
			String config = "com/baobaotao/basic/beans.xml";
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
			Waiter waiter = applicationContext.getBean("waiter",Waiter.class);
			
			waiter.greetTo("John");
			Seller seller = (Seller)waiter;
			seller.sell("Beer", "John");
			
	}
}
