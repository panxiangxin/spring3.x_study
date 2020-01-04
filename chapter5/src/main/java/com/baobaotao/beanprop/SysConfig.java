package com.baobaotao.beanprop;

import javax.sql.DataSource;

public class SysConfig {
	
	private int sessionTimeout;
	private int maxTabPageNum;
	private DataSource dataSource;
	
	public void initFromDB() {
		this.sessionTimeout = 30;
		this.maxTabPageNum = 10;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public int getMaxTabPageNum() {
		return maxTabPageNum;
	}

	public void setMaxTabPageNum(int maxTabPageNum) {
		this.maxTabPageNum = maxTabPageNum;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
}
