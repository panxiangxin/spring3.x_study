package com.baobaotao.dao;

import com.baobaotao.domain.Forum;

public interface ForumDao {

	Forum getForum(int forumId);

	int getForumNum();
	
	void updateForum(Forum forum);

}
