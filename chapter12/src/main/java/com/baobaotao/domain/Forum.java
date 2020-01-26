package com.baobaotao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="t_forum")
public class Forum implements Serializable{
	@Id
	@Column(name = "forum_id")
	private int forumId;
	
	@Column(name = "forum_name")
	private String forumName;
	
	@Column(name = "forum_desc")
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
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
