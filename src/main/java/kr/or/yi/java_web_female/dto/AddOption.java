package kr.or.yi.java_web_female.dto;

public class AddOption {
	private int id; //erd에서 변수명은 option_id
	private String code; //erd에서 변수명은 car_code
	
	//get set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "AddOption [id=" + id + ", code=" + code + "]";
	}

}
