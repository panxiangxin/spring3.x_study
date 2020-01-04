package com.baobaotao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{

	private String brand;
	private String color;
	private int maxSpeed;
	private BeanFactory beanFactory;
	private String beanName;
	
	//默认构造函数
	
	public Car() {
		System.out.println("调用Car()构造函数");
	}
	//带参构造函数
	public Car(String brand, String color, int maxSpeed) {
		super();
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	//未带参的方法
	public void introduce() {
	       System.out.println("brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
		}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		System.out.println("调用setBrand()设置属性");
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	//DisposableBean接口方法
	@Override
	public void destroy() throws Exception {
		System.out.println("调用Disposable。destory()方法");
	}
	//InitializingBean接口方法
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用InitializingBean.afterPropertiesSet()方法");
		
	}
	//BeanNameAware接口方法
	@Override
	public void setBeanName(String arg0) {
		System.out.println("调用BeanNameAware.setBeanName()方法");
		this.beanName = arg0;
	}
	//BeanFactoryAware接口方法
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		
		System.out.println("调用BeanFactoryAware.setBeanFactorry()方法");
		this.beanFactory = arg0;
	}
	public void myInit() {
		System.out.println("调用init-method所指定的myinit(),将maxSpeed设置为240");
		this.maxSpeed = 240;
	}
	
	public void myDestroy() {
		System.out.println("调用destory-method所指定的myDestroy()");
	}
}
