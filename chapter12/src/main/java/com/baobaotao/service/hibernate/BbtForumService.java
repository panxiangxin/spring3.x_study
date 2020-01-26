package com.baobaotao.service.hibernate;

import com.baobaotao.dao.hibernate.ForumHibernateDao;
import com.baobaotao.dao.hibernate.PostHibernateDao;
import com.baobaotao.dao.hibernate.TopicHibernateDao;
import com.baobaotao.domain.Forum;
import com.baobaotao.domain.Post;
import com.baobaotao.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pxx
 * Date 2020/1/26 11:10
 * @Description
 */

@Service
public class BbtForumService {

	@Autowired
	private ForumHibernateDao forumDao;
	
	@Autowired
	private TopicHibernateDao topicDao;
	
	@Autowired
	private PostHibernateDao postDao;
	
	public void addForum(Forum forum) {
		forumDao.addForum(forum);
	}
	public void addTopic(Topic topic) {
		topicDao.addTopic(topic);
	}
	public void addPost(Post post) {
		postDao.addPost(post);
	}
	
	public Forum getForum(int forumId) {
		return forumDao.getForum(forumId);
	}
	public void updateForum(Forum forum) {
		forumDao.updateForum(forum);
	}
	public long getForumNum() {
		return forumDao.getForumNum();
	}
	public List findForumByName(String forumName) {
		return forumDao.findForumByName(forumName);
	}
	public Post getPost(int postId) {
		return postDao.getPost(postId);
	}
	
	
	
}
