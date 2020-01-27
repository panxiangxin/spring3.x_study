package com.baobaotao.basic.quartz.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author pxx
 * Date 2020/1/27 13:00
 * @Description
 */
public class SimpleTimerTask extends TimerTask {
	
	private int count = 0;
	
	@Override
	public void run() {
		System.out.println("execute task.");
		Date exeTime = (new Date(scheduledExecutionTime()));
		System.out.println("本次任务安排执行的时间点：" + exeTime);
		
		if (++count > 10) {
			cancel();
		}
	}
}
