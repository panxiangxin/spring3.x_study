package com.baobaotao.basic.quartz.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author pxx
 * Date 2020/1/27 13:02
 * @Description
 */
public class TimerRunner {
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new SimpleTimerTask();
		timer.schedule(task, 1000L, 5000L);
	}
}
