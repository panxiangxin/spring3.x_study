package com.baobaotao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

class GreetingAfterAdvice implements AfterReturningAdvice{

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("Please enjoy youeself!");
		
	}

	
}
