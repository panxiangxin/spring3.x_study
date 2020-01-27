package com.baobaotao.basic.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/27 10:41
 * @Description
 */
public class SimpleJob implements Job {
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println(jobExecutionContext.getTrigger().getKey() + " triggered. time is:" + (new Date()));
	}
}
