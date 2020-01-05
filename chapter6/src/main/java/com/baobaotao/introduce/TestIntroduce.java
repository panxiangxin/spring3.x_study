package com.baobaotao.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIntroduce {
	public static void main(String[] args) {
		
		String config = "com/baobaotao/introduce/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
		
		ForumService forumService = applicationContext.getBean("forumService",ForumService.class);
		
		forumService.removeForum(10);
		forumService.removeTopic(20);
		
		Monitorable monitorable = (Monitorable)forumService;
		monitorable.setMointorActive(true);
		
		forumService.removeForum(10);
		forumService.removeTopic(20);
	}

}
