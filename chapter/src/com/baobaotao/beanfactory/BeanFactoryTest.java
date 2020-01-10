package com.baobaotao.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baobaotao.Car;

public class BeanFactoryTest {
	
	public static void main(String[] args) {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("com/baobaotao/beanfactory/beans.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		System.out.println("init BeanFactory");
		
		Car car = beanFactory.getBean("car",Car.class);
		
		System.out.println("car bean is ready for use!");
	}

}
