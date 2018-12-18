package kr.or.yi.java_web_female.dto;

public class Insurance {
	private String code;	//보험코드
	private String carType;	//차종(경차, 소형, 중형, ..)
	private int price;	//보험료
	
	public Insurance() {
		// TODO Auto-generated constructor stub
	}

	public Insurance(String code, String carType, int price) {
		this.code = code;
		this.carType = carType;
		this.price = price;
	}

	public Insurance(String code) {
		this.code = code;
	}

	//getter, setter
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return String.format("%s, %s, %s", code, carType, price);
	}	
}
