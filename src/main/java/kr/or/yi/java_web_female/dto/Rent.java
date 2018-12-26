package kr.or.yi.java_web_female.dto;

public class Rent {
	private String code;	//대여코드
	private String startDate;	//대여시작일
	private String startTime; //대여시작시간
	private String endDate;	//대여반납일
	private String endTime;	//대여반납시간
	private boolean isReturn;	//반납여부
	private long totalPrice;	//대여총비용(DB -> basic_price)
	private CarModel carCode;	//차량코드
	private Customer customerCode;	//고객코드
	private Insurance insuranceCode;	//보험코드
	private String eCode;
	private int optPrice;	//옵션비용
	
	public Rent() {
		// TODO Auto-generated constructor stub
	}

	public Rent(String code, String startDate, String startTime, String endDate, String endTime, boolean isReturn,
		long totalPrice, CarModel carCode, Customer customerCode, Insurance insuranceCode, String eCode, int optPrice) {
	this.code = code;
	this.startDate = startDate;
	this.startTime = startTime;
	this.endDate = endDate;
	this.endTime = endTime;
	this.isReturn = isReturn;
	this.totalPrice = totalPrice;
	this.carCode = carCode;
	this.customerCode = customerCode;
	this.insuranceCode = insuranceCode;
	this.eCode = eCode;
	this.optPrice = optPrice;
	}

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CarModel getCarCode() {
		return carCode;
	}

	public void setCarCode(CarModel carCode) {
		this.carCode = carCode;
	}

	public Customer getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Customer customerCode) {
		this.customerCode = customerCode;
	}

	public Insurance getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(Insurance insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public int getOptPrice() {
		return optPrice;
	}

	public String geteCode() {
		return eCode;
	}

	public void seteCode(String eCode) {
		this.eCode = eCode;
	}

	public void setOptPrice(int optPrice) {
		this.optPrice = optPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"Rent [code=%s, startDate=%s, startTime=%s, endDate=%s, endTime=%s, isReturn=%s, totalPrice=%s, carCode=%s, customerCode=%s, insuranceCode=%s, eRate=%s, optPrice=%s]",
				code, startDate, startTime, endDate, endTime, isReturn, totalPrice, carCode, customerCode,
				insuranceCode, eCode, optPrice);
	}

	
}
