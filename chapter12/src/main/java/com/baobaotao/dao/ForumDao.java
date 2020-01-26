package com.baobaotao.dao;

/**
 * @author pxx
 * Date 2020/1/26 13:26
 * @Description
 */
public class ForumDao extends BaseDao<ForumDao> {
	
	public long getForumNum() {
		Object object = getHibernateTemplate().iterate("select count (f.forumId) from Forum f").next();
		return (Long)object;
	}
}
