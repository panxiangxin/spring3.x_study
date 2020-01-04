package com.baobaotao.attr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class Boss {
	
	private Car car = new Car();
	private List favorites = new ArrayList();
	private Map jobs = new HashMap();
	private Properties mails = new Properties();
	private Map<String, Integer> jobTimeMap = new HashMap<String, Integer>();
	

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List getFavorites() {
		return favorites;
	}

	public void setFavorites(List favorites) {
		this.favorites = favorites;
	}

	public Map getJobs() {
		return jobs;
	}

	public void setJobs(Map jobs) {
		this.jobs = jobs;
	}

	public Properties getMails() {
		return mails;
	}

	public void setMails(Properties mails) {
		this.mails = mails;
	}

	public Map<String, Integer> getJobTimeMap() {
		return jobTimeMap;
	}

	public void setJobTimeMap(Map<String, Integer> jobTimeMap) {
		this.jobTimeMap = jobTimeMap;
	}
	
	
	
}
