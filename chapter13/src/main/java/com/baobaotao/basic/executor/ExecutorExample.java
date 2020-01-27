package com.baobaotao.basic.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author pxx
 * Date 2020/1/27 13:11
 * @Description
 */
public class ExecutorExample {
	
	private Executor executor;
	
	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	public void executorTasks() {
		for (int i = 0; i < 6; i++) {
			executor.execute(new SimpleTask("task" + i));
		}
	}
	
	public static void main(String[] args) {
		ExecutorExample executorExample = new ExecutorExample();
		executorExample.setExecutor(Executors.newFixedThreadPool(3));
		executorExample.executorTasks();
	}
	
}
class SimpleTask implements Runnable{
	private String taskName;
	
	public SimpleTask(String taskName) {
		this.taskName = taskName;
	}
	public void run() {
		System.out.println("do" + taskName + "... in Thread:" + Thread.currentThread().getId());
	}
	
}
