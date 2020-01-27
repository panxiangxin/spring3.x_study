package com.baobaotao.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author pxx
 * Date 2020/1/27 11:41
 * @Description
 */
public class CronTriggerRunner {
	public static void main(String[] args) {
		
		JobDetail jobDetail = JobBuilder
									  .newJob(SimpleJob.class)
									  .withIdentity("job1_2", "jGroup2")
									  .build();
		
		CronTrigger cronTrigger = TriggerBuilder
										  .newTrigger()
										  .withIdentity("trigger1_2", "tgroup2")
										  .withSchedule(CronScheduleBuilder.cronSchedule("0/15 * * * * ?"))
										  .build();
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
