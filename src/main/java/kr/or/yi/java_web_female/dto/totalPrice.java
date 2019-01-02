package kr.or.yi.java_web_female.dto;

public class totalPrice {
	private String brand;
	private String carType;
	private int totalPrice;
	
	public totalPrice() {
		// TODO Auto-generated constructor stub
	}
	
	public totalPrice(String brand, String carType, int totalPrice) {
		this.brand = brand;
		this.carType = carType;
		this.totalPrice = totalPrice;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return String.format("totalPrice [brand=%s, carType=%s, totalPrice=%s]", brand, carType, totalPrice);
	}
	
	
}
