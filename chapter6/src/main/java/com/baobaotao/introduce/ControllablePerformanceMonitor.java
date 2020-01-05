package com.baobaotao.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable{
	
	private static ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

	public void setMointorActive(boolean active) {		
		MonitorStatusMap.set(active);
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		Object obj = null;
		
		if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
			PerformanceMonitor.begin(mi.getClass().getName() + "."
					+ mi.getMethod().getName());
			obj = super.invoke(mi);
			PerformanceMonitor.end();
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}
}
