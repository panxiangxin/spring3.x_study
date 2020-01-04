package com.baobaotao.i18;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceBundleMessageSource {

	public static void main(String[] args) {
		String[] configs = {"com/baobaotao/i18/beans.xml"};
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		MessageSource ms = (MessageSource) ctx.getBean("myResource1");
		Object[] params = {"John",new GregorianCalendar().getTime()};
		
		String str1 = ms.getMessage("greeting.common", params, Locale.US);
		String str2 = ms.getMessage("greeting.common", params, Locale.CHINA);
		String str3 = ms.getMessage("greeting.afternoon", params, Locale.CHINA);
				
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}