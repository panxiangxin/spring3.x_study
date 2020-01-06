package com.baobaotao.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {

	@AfterReturning("@annotation(com.baobaotao.anno.NeedTest)")
	public void needTestFun() {
		System.out.println("needTestFun executed!");
	}
}
