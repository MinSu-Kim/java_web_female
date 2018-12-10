package kr.or.yi.java_web_female.dto;

public class Event {
	private String code;
	private String name;
	private int rate;
	
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
		return "Event [code=" + code + ", name=" + name + ", rate=" + rate + "]";
	}
	
	
} 
