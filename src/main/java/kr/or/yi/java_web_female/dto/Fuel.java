package kr.or.yi.java_web_female.dto;

public class Fuel {
	private String code;
	private int no;
	

	public Fuel() {

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Fuel(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Fuel [code=" + code + ", no=" + no + "]";
	}

	
	
	
}
