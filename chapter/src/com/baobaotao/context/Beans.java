package com.baobaotao.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baobaotao.Car;

@Configuration
public class Beans {

	@Bean(name = "car")
	public Car buildCar() {
		
		Car car = new Car();
		car.setBrand("五菱宏光");
		car.setMaxSpeed(200);
		return car;
	}
}
