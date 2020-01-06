package com.baobaotao.example;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.baobaotao.NaiveWaiter;
import com.baobaotao.Waiter;
import com.baobaotao.aspectj.PreGreetingAspect;

public class AspectProxyTest {
	
	public static void main(String[] args) {
	
		Waiter target = new NaiveWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		
		factory.setTarget(target);
		
		factory.addAspect(PreGreetingAspect.class);
		
		Waiter proxy = factory.getProxy();
		
		proxy.greetTo("John");
		proxy.serveTo("John");
	}

}
