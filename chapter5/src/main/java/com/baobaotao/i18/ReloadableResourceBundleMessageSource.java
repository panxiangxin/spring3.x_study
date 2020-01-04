package com.baobaotao.i18;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReloadableResourceBundleMessageSource {
	public static void main(String[] args) throws Exception {

//		String[] configs = {"com/baobaotao/i18/beans.xml"};
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
//		
//		MessageSource ms = (MessageSource)ctx.getBean("myResource2");
//		Object[] params = {"John", new GregorianCalendar().getTime()};
//		
//		for (int i = 0; i < 2; i++) {
//			String str1 = ms.getMessage("greeting.common",params,Locale.US);		
//			System.out.println(str1);
//			Thread.currentThread().sleep(20000);
//		}	
		
		ctxMessageResource();
	}
	private static void ctxMessageResource() throws Exception{
		String[] configs = {"com/baobaotao/i18/beans.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		Object[] params = {"John", new GregorianCalendar().getTime()};
		
		String str1 = ctx.getMessage("greeting.common",params,Locale.US);
		String str2 = ctx.getMessage("greeting.morning",params,Locale.CHINA);	
		System.out.println(str1);
		System.out.println(str2);	
	}	
}
