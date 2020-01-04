package com.baobaotao.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[] { "com/baobaotao/attr/beans1.xml"});
		
		ApplicationContext factory = new ClassPathXmlApplicationContext(new String[] {"com/baobaotao/attr/beans2.xml"},pFactory);
		
		Boss boss = (Boss) factory.getBean("boss");
		
		System.out.println(boss.getCar().toString());
		
		
		ApplicationContext fApplicationContext = new ClassPathXmlApplicationContext(new String[] {"com/baobaotao/attr/beans.xml"});
		
		Boss boss1 = (Boss) fApplicationContext.getBean("boss1");
		
		System.out.println(boss1.getCar()+""+boss1.getMails()+""+boss1.getFavorites());
		
	}

}
