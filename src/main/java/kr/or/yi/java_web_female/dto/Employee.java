package kr.or.yi.java_web_female.dto;

public class Employee {
	private String code; //직원코드
	private String name; //직원이름
	private String phone; //연락처
	private String passwd; // 비밀번호
	private Title tCode;// 직책 코드
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Title gettCode() {
		return tCode;
	}
	public void settCode(Title tCode) {
		this.tCode = tCode;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", name=" + name + ", phone=" + phone + ", passwd=" + passwd + ", tCode="
				+ tCode + "]";
	}
	
	
}
