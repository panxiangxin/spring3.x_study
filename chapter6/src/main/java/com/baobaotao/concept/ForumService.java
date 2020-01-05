package com.baobaotao.concept;


public class ForumService {
	
	private TransactionManager transactionManager;
	private PerformanceMonitor pmonitor;
	private TopicDao topicDao;
	private ForumDao forumDao;
	
	public 	void removeTopic(int topicId) {
		pmonitor.start();
		transactionManager.beginTransaction();
		topicDao.removeTopic(topicId);
		transactionManager.endTransaction();
		pmonitor.end();
	}
	public void createForum(Forum forum) {
		pmonitor.start();
		transactionManager.beginTransaction();
		forumDao.create(forum);
		transactionManager.endTransaction();
		pmonitor.end();
	}
}
