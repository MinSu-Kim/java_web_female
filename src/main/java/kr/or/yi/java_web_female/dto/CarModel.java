package kr.or.yi.java_web_female.dto;

import java.util.List;

public class CarModel {
	private String carCode;
	private String name;
	private String color;
	private String gear;
	private Brand brand;
	private CarType cartype;
	private int basicCharge;
	private int hour6;
	private int hour10;
	private int hour12;
	private int hourElse;
	private Fuel fuel;
	private boolean isRent;
	private int rentCnt;
	private List<CarOption> carOption;
	
	
	public CarModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarModel(String carCode) {
		super();
		this.carCode = carCode;
	}
	//get, set
	
	public String getCarCode() {
		return carCode;
	}
	public int getBasicCharge() {
		return basicCharge;
	}
	public void setBasicCharge(int basicCharge) {
		this.basicCharge = basicCharge;
	}
	
	public List<CarOption> getCarOption() {
		return carOption;
	}
	public void setCarOption(List<CarOption> carOption) {
		this.carOption = carOption;
	}
	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGear() {
		return gear;
	}
	public void setGear(String gear) {
		this.gear = gear;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public CarType getCartype() {
		return cartype;
	}
	public void setCartype(CarType cartype) {
		this.cartype = cartype;
	}
	public int getBasic_charge() {
		return basicCharge;
	}
	public void setBasic_charge(int basic_charge) {
		this.basicCharge = basic_charge;
	}
	public int getHour6() {
		return hour6;
	}
	public void setHour6(int hour6) {
		this.hour6 = hour6;
	}
	public int getHour10() {
		return hour10;
	}
	public void setHour10(int hour10) {
		this.hour10 = hour10;
	}
	public int getHour12() {
		return hour12;
	}
	public void setHour12(int hour12) {
		this.hour12 = hour12;
	}
	public int getHourElse() {
		return hourElse;
	}
	public void setHourElse(int hourElse) {
		this.hourElse = hourElse;
	}
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	public boolean isRent() {
		return isRent;
	}
	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}
	public int getRentCnt() {
		return rentCnt;
	}
	public void setRentCnt(int rentCnt) {
		this.rentCnt = rentCnt;
	}
	@Override
	public String toString() {
		return "CarModel [carCode=" + carCode + ", name=" + name + ", color=" + color + ", gear=" + gear + ", brand="
				+ brand + ", cartype=" + cartype + ", basicCharge=" + basicCharge + ", hour6=" + hour6 + ", hour10="
				+ hour10 + ", hour12=" + hour12 + ", hourElse=" + hourElse + ", fuel=" + fuel + ", isRent=" + isRent
				+ ", rentCnt=" + rentCnt + ", carOption=" + carOption + "]";
	}
	
	
	
	
}
