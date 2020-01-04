package com.baobaotao.editor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/baobaotao/editor/beans.xml");
		
		Boss boss = ctx.getBean("boss",Boss.class);
		
		System.out.println(boss.getCar());
		
	}
}