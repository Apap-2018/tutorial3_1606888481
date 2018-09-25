package com.apap.tutorial3.model;

public class CarModel {
	public String id;
	public String brand;
	public String type;
	public long price;
	public Integer amount;

	public CarModel() {	}

	public CarModel(String id, String brand, String type, long price, Integer amount) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.amount = amount;
		
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
}
