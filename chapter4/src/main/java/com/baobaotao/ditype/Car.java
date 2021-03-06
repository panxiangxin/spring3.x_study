package com.baobaotao.ditype;

public class Car {
	
	private int maxSpeed;
	private String brand;
	private double price;
	private String corp;	
	
	
	public Car() {
	}
	
	public Car(String brand,double price) {

		this.brand = brand;
		this.price = price;
	}
	
	public Car(String brand, String corp, double price) {
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	public Car(String brand, String corp, int maxSpeed) {
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}

	
	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [maxSpeed=" + maxSpeed + ", brand=" + brand + ", price=" + price + ", corp=" + corp + "]";
	}
	
}
