package com.baobaotao.proxy;

public class PerformanceMonitor {

	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
	
	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformance mPerformance = new MethodPerformance(method);
		performanceRecord.set(mPerformance);
	}
	
	public static void end() {
		System.out.println("end monitor。。。");
		MethodPerformance mPerformance = performanceRecord.get();
		mPerformance.printPerformance();
	}
}
