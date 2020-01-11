package com.baobaotao.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author www72
 */
public class Forum implements Serializable {
	
	private int forumId;
	private String forumName;
	private String forumDesc;
	
	public String getForumDesc() {
		return forumDesc;
	}
	
	public void setForumDesc(String forumDesc) {
		this.forumDesc = forumDesc;
	}
	
	public int getForumId() {
		return forumId;
	}
	
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
	public String getForumName() {
		return forumName;
	}
	
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
