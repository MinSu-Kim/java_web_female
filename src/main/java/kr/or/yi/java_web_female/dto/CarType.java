package kr.or.yi.java_web_female.dto;

public class CarType {
	private String code;//erd와 변수명 동일
	private String type;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "CarType [code=" + code + ", type=" + type + "]";
	}
	
	
}
