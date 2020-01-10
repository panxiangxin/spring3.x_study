package com.baobaotao.special;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author pxx
 * Date 2020/1/10 14:24
 * @Description
 */
@Service("userService")
public class UserService {
	
	private void method1(){
		System.out.println("UserService.method1");
	}
	
	public final void method2(){
		System.out.println("UserService.method2");
	}
	
	public static void method3(){
		System.out.println("UserService.method3");
	}
	
	public void method4() {
		System.out.println("UserService.method4");
	}
	public final void method5(){
		System.out.println("UserService.method5");
	}
	protected void method6(){
		System.out.println("UserService.method6");
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-spe.xml");
		UserService service = (UserService) applicationContext.getBean("userService");
		
		System.out.println("before method1");
		service.method1();
		System.out.println("after method1");
		
		System.out.println("before method2");
		service.method2();
		System.out.println("after method2");
		
		System.out.println("before method3");
		method3();
		System.out.println("after method3");
		
		System.out.println("before method4");
		service.method4();
		System.out.println("after method4");
		
		System.out.println("before method5");
		service.method5();
		System.out.println("after method5");
		
		System.out.println("before method6");
		service.method6();
		System.out.println("after method6");
	}
}
