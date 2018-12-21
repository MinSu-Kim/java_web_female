package kr.or.yi.java_web_female.dto;

public class Employee {
	private String code; // 직원코드
	private String name; // 직원이름
	private String phone; // 연락처
	private String passwd; // 비밀번호
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	public Employee(String code, String name, String phone, String passwd) {
		super();
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.passwd = passwd;
	}
	public Employee(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public Employee(String code) {
		super();
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format("Employee [code=%s, name=%s, phone=%s, passwd=%s]", code, name, phone, passwd);
	}
	



}
