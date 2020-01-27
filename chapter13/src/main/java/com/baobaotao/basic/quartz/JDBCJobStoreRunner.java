package com.baobaotao.basic.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

/**
 * @author pxx
 * Date 2020/1/27 12:37
 * @Description
 */
public class JDBCJobStoreRunner {
	
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		List<String> triggerGroups = scheduler.getTriggerGroupNames();
		
		
	}
}
