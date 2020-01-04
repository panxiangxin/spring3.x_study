package com.baobaotao.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.baobaotao.Car;

public class AnnotationApplicationContext {

	public static void main(String[] args) {
		
		//通过一个带@Configuration的POJO装载Bean配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		Car car = ctx.getBean("car",Car.class);
		System.out.println(car.getBrand());
	}
}
