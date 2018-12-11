package kr.or.yi.java_web_female.dto;

public class Grade {
	private String code; //등급 코드
	private String name; //등급명
	private int rate; //등급별 할인율
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	
	public Grade(String code) {
		this.code = code;
	}
	
	public Grade(String code, String name, int rate) {
		this.code = code;
		this.name = name;
		this.rate = rate;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "Grade [code=" + code + ", name=" + name + ", rate=" + rate + "]";
	}
	
	
}
