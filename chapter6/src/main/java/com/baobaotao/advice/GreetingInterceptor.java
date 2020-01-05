package com.baobaotao.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class GreetingInterceptor implements MethodInterceptor{

	public Object invoke(MethodInvocation arg0) throws Throwable {

		Object[] args = arg0.getArguments();
		String clientName = (String)args[0];
		
		System.out.println("How are you ! Mr."+clientName+ ".");
		Object obj = arg0.proceed();
		System.out.println("Please enjoy oyourself!");
		return obj;
	}

}
