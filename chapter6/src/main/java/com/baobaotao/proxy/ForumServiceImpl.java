package com.baobaotao.proxy;

public class ForumServiceImpl implements ForumService{

	public void removeTopic(int topicId) {
		
//		PerformanceMonitor.begin("com.baobaotao.proxy.ForumServiceImpl.removeTopic");
		System.out.println("模拟topic删除记录："+topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PerformanceMonitor.end();
		
	}

	public void removeForum(int forumId) {
		
//		PerformanceMonitor.begin("com.baobaotao.proxy.ForumServiceImpl.removeForum");
		System.out.println("模拟forum删除记录："+forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PerformanceMonitor.end();
		
	}

}
