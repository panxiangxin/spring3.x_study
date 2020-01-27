package com.baobaotao.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author pxx
 * Date 2020/1/27 10:56
 * @Description
 */
public class SimpleTriggerRunner {
	
	public static void main(String[] args) {
		JobDetail jobDetail = JobBuilder
									  .newJob(SimpleJob.class)
									  .withIdentity("job1_1", "jgroup1")
									  .build();
		
		SimpleTrigger simpleTrigger = TriggerBuilder
											  .newTrigger()
											  .withIdentity("trigger1_1", "tgroup1")
											  .startAt(new Date())
											  .withSchedule(SimpleScheduleBuilder
																	.simpleSchedule()
																	.withRepeatCount(100)
																	.withIntervalInSeconds(10))
											  .build();
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, simpleTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
