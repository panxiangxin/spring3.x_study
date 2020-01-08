package com.baobaotao.service.Impl;

import org.springframework.transaction.annotation.Transactional;

import com.baobaotao.dao.ForumDao;
import com.baobaotao.dao.PostDao;
import com.baobaotao.dao.TopicDao;
import com.baobaotao.domain.Forum;
import com.baobaotao.domain.Topic;
import com.baobaotao.service.BbtForum;

@Transactional
public class BbtForumImpl implements BbtForum{
	
	private ForumDao forumDao;
	private TopicDao topicDao;
	private PostDao postDao;

	public void addTopic(Topic topic) {
		
		topicDao.addTopic(topic);
		postDao.addPost(topic.getPost());
	}

	public void updateForum(Forum forum) {
		forumDao.updateForum(forum);
	}

	@Transactional(readOnly=true)
	public Forum getForum(int forumId) {
		return forumDao.getForum(forumId);
	}

	public int getForumNum() {
		return forumDao.getForumNum();
	}

	public ForumDao getForumDao() {
		return forumDao;
	}

	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	
}
