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
		return String.format("%s", code);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	
	



}
