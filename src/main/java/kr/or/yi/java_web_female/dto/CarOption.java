package kr.or.yi.java_web_female.dto;

public class CarOption {
	private int no; //ere에서의 변수명과 모두 동일
	private String name;
	private int price;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarOption [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
