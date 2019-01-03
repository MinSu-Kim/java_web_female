package kr.or.yi.java_web_female.dto;

public class StateCar {
	
	private String title;
	private int count;
	private String type;	//차 종류
	private String brand;
	private String name;	//차 이름
	private String customerCode;	//고객 코드
	
	public StateCar() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return String.format("StateCar [title=%s, count=%s, type=%s, brand=%s, name=%s, customerCode=%s]", title, count,
				type, brand, name, customerCode);
	}	
}
