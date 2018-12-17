package kr.or.yi.java_web_female.dto;

import java.util.Date;

public class Customer {
	private String code;
	private String id;
	private String passwd;
	private String name;
	private String address;
	private String phone;
	private Date dob;
	private String email;
	private Employee empCode;
	private String license;
	private Grade gradeCode;
	private int rentCnt;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String passwd) {
		super();
		this.id = id;
		this.passwd = passwd;
	}

	public Customer(String id, String passwd, String name, String address, String phone, java.util.Date cusDob,
			String email) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = cusDob;
		this.email = email;
	}

	public Customer(String code, String name, Grade gradeCode, String phone, String email) {
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gradeCode = gradeCode;
	}

	public Customer(String cusId) {
		this.id = cusId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Employee empCode) {
		this.empCode = empCode;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Grade getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(Grade gradeCode) {
		this.gradeCode = gradeCode;
	}

	public int getRentCnt() {
		return rentCnt;
	}

	public void setRentCnt(int rentCnt) {
		this.rentCnt = rentCnt;
	}

	@Override
	public String toString() {
		return "Customer [code=" + code + ", id=" + id + ", passwd=" + passwd + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", dob=" + dob + ", email=" + email + ", empCode=" + empCode
				+ ", license=" + license + ", gradeCode=" + gradeCode + ", rentCnt=" + rentCnt + "]";
	}

}
