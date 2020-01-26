package com.baobaotao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "t_post")
public class Post implements Serializable {
	@Id
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "user_id")
	private int userId;
	
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	@Lob
	@Column(name = "post_text")
	private String postText;
	
	@Lob
	@Column(name = "post_attach")
	private byte[] postAttach;
	
	@Column(name = "post_time")
	private Date postTime;
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getPostText() {
		return postText;
	}
	
	public void setPostText(String postText) {
		this.postText = postText;
	}
	
	public Date getPostTime() {
		return postTime;
	}
	
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public byte[] getPostAttach() {
		return postAttach;
	}
	
	public void setPostAttach(byte[] postAttach) {
		this.postAttach = postAttach;
	}
	
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
