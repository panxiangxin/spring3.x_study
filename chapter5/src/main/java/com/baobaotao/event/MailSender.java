package com.baobaotao.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;
	}

	public void sendMail(String to) {
		System.out.println("MailSender:模拟发送邮件...");
		MailSendEvent mailSendEvent = new MailSendEvent(applicationContext, to);
		//向容器中的所有监听器发布事件
		applicationContext.publishEvent(mailSendEvent);
	}
}
