package com.baobaotao.domain;

import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/28 14:45
 * @Description
 */
public class LoginLog {

	
	private int userId;
	private int loginLogId;
	private String ip;
	private Date loginDate;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getLoginLogId() {
		return loginLogId;
	}
	
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
	public String toString() {
		return "LoginLog{" +
					   "userId=" + userId +
					   ", loginLogId=" + loginLogId +
					   ", ip='" + ip + '\'' +
					   ", loginDate=" + loginDate +
					   '}';
	}
}
