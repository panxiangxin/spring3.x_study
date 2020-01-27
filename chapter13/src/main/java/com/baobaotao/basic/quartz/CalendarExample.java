package com.baobaotao.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author pxx
 * Date 2020/1/27 11:54
 * @Description
 */
public class CalendarExample {
	public static void main(String[] args) {
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler scheduler = schedulerFactory.getScheduler();
			
			AnnualCalendar holidays = new AnnualCalendar();
			
			Calendar laborDay = new GregorianCalendar();
			laborDay.add(Calendar.MONTH, 5);
			laborDay.add(Calendar.DATE, 1);
			
			Calendar nationDay = new GregorianCalendar();
			nationDay.add(Calendar.MONTH, 10);
			nationDay.add(Calendar.DATE, 1);
			
			ArrayList<Calendar> calendars = new ArrayList<Calendar>();
			calendars.add(laborDay);
			calendars.add(nationDay);
			
			holidays.setDaysExcluded(calendars);
			
			scheduler.addCalendar("holidays", holidays, false, false);
			Date runDate = new Date(2020, Calendar.APRIL, 1);
			
			JobDetail jobDetail = JobBuilder
										  .newJob(SimpleJob.class)
										  .withIdentity("job1", "jgroup1")
										  .build();
			
			SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
												  .withIdentity("trigger1", "group1")
												  .startAt(runDate)
												  .withSchedule(SimpleScheduleBuilder
																		.simpleSchedule()
																		.withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
																		.withIntervalInSeconds((int) (60L * 60L * 1000L)))
												  .build();
			
			scheduler.scheduleJob(jobDetail, simpleTrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
}
