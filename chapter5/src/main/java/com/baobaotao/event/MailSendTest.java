package com.baobaotao.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailSendTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/baobaotao/event/beans.xml");
		
		MailSender mailSender = applicationContext.getBean("mailSender", MailSender.class);
		mailSender.sendMail("821297578@qq.com");
	}
}
