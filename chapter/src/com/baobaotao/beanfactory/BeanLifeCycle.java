package com.baobaotao.beanfactory;

import com.baobaotao.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
	
	private static void LifeCycleInBeanFactory() {
		
		Resource resource = new ClassPathResource("com/baobaotao/beanfactory/beans.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
		
		((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		Car car1 = (Car) beanFactory.getBean("car");
		car1.introduce();
		car1.setColor("红色");
		
		
		Car car2 = (Car) beanFactory.getBean("car");
		
		System.out.println("car1==car2: "+(car1==car2));
		
		beanFactory.destroySingletons();
		
	}
	public static void main(String[] args) {
		LifeCycleInBeanFactory();
	}
}
