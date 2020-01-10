package com.baobaotao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/10 11:20
 * @Description
 */
@Entity
@Table(name = "user_example")
public class User implements Serializable {
	
	@Id
	@Column(name = "user_name")
	private String userName;
	
	private String password;
	
	private int score;
	
	@Column(name = "last_login_time")
	private long lastLoginTime;
	
	public String getUserName() {
		return userName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	@Override
	public String toString() {
		return "User{" +
					   "userName='" + userName + '\'' +
					   ", password='" + password + '\'' +
					   ", score=" + score +
					   ", lastLoginTime=" + lastLoginTime +
					   '}';
	}
}
