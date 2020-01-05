package com.baobaotao.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {

	public static void main(String[] args) {
//		ForumService target = new ForumServiceImpl();
		
//		PerformanceHandler handler = new PerformanceHandler(target);
//		ForumService proxy = (ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
//		proxy.removeForum(50);
//		proxy.removeTopic(20);
		
		CglibProxy proxy = new CglibProxy();
		ForumServiceImpl forumServiceImpl = (ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
		forumServiceImpl.removeForum(50);
		forumServiceImpl.removeTopic(20);
		
	}
}
