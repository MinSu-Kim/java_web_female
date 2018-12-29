package kr.or.yi.java_web_female.dto;

import java.util.Date;
import java.util.List;

public class Customer {
	private String code;
	private String id;
	private String passwd;
	private String name;
	private String zipCode;
	private String address;
	private String phone;
	private Date dob;
	private String email;
	private Employee empCode;
	private String license;
	private Grade gradeCode;
	private int rentCnt;
	private List<CustomEvent> events;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String passwd) {
		super();
		this.id = id;
		this.passwd = passwd;
	}

	public Customer(String id, String passwd, String name, String zipCode, String address, String phone, Date dob,
			String email, Employee empCode, String license, Grade gradeCode, int rentCnt) {

		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.email = email;
		this.empCode = empCode;
		this.license = license;
		this.gradeCode = gradeCode;
		this.rentCnt = rentCnt;
	}

	public Customer(String code, String id, String passwd, String name, String address, String phone, Date dob,
			String email, Employee empCode, String license, Grade gradeCode, int rentCnt, List<CustomEvent> events) {
		super();
		this.code = code;
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.email = email;
		this.empCode = empCode;
		this.license = license;
		this.gradeCode = gradeCode;
		this.rentCnt = rentCnt;
		this.events = events;
	}

	public Customer(String id, String passwd, String name, String address, String phone, Date dob, String email,
			String license) {
		super();

		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.email = email;
		this.license = license;
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

	public List<CustomEvent> getEvents() {
		return events;
	}

	public void setEvents(List<CustomEvent> events) {
		this.events = events;
	}

	/*@Override
	public String toString() {
		return String.format(
				"Customer [code=%s, id=%s, passwd=%s, name=%s, zipCode=%s, address=%s, phone=%s, dob=%s, email=%s, empCode=%s, license=%s, gradeCode=%s, rentCnt=%s, events=%s]",
				code, id, passwd, name, zipCode, address, phone, dob, email, empCode, license, gradeCode, rentCnt,
				events);
	}*/
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [code=%s, id=%s, passwd=%s, name=%s, zipCode=%s, address=%s, phone=%s, dob=%s, email=%s, empCode=%s, license=%s, gradeCode=%s, rentCnt=%s, events=%s]",
				code, id, passwd, name, zipCode, address, phone, dob, email, empCode, license, gradeCode, rentCnt,
				events);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	

}
