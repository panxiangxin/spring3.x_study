package com.baobaotao.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice{

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
		String clientName = (String)arg1[0];
		System.out.println("How are you!  Mr."+clientName+".");
		
	}

}
