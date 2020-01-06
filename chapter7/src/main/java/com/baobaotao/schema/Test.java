package com.baobaotao.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.Seller;
import com.baobaotao.Waiter;



public class Test {
 public static void main(String[] args) {
	
	 String config = "com/baobaotao/schema/beans.xml";
	 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
	 Waiter naiveWaiter = (Waiter)applicationContext.getBean("naiveWaiter");
	 Waiter naughtyWaiter = (Waiter)applicationContext.getBean("naughtyWaiter");
	 
//	 naiveWaiter.greetTo("John");
//	 naughtyWaiter.greetTo("John");
	 
	 ((Seller)naiveWaiter).sell("Beer","John");
}
}
