package kr.or.yi.java_web_female.dto;

import java.util.Date;

public class Rent {
	private String code;	//대여코드
	private Date startDate;	//대여시작일
	private Date startTime; //대여시작시간
	private Date endDate;	//대여반납일
	private Date endTime;	//대여반납시간
	private boolean isReturn;	//반납여부
	private int totalPrice;	//대여총비용(DB -> basic_price)
	private CarModel carCode;	//차량코드
	private Employee customerCode;	//고객코드
	private Insurance insuranceCode;	//보험코드
	private Event eRate;	//이벤트 할인율
	private int optPrice;	//옵션비용
	
	public Rent() {
		// TODO Auto-generated constructor stub
	}

	public Rent(String code, Date startDate, Date startTime, Date endDate, Date endTime, boolean isReturn,
			int totalPrice, CarModel carCode, Employee customerCode, Insurance insuranceCode, Event eRate,
			int optPrice) {
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
		this.eRate = eRate;
		this.optPrice = optPrice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CarModel getCarCode() {
		return carCode;
	}

	public void setCarCode(CarModel carCode) {
		this.carCode = carCode;
	}

	public Employee getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Employee customerCode) {
		this.customerCode = customerCode;
	}

	public Insurance getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(Insurance insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public Event geteRate() {
		return eRate;
	}

	public void seteRate(Event eRate) {
		this.eRate = eRate;
	}

	public int getOptPrice() {
		return optPrice;
	}

	public void setOptPrice(int optPrice) {
		this.optPrice = optPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s",
				code, startDate, startTime, endDate, endTime, isReturn, totalPrice, carCode, customerCode,
				insuranceCode, eRate, optPrice);
	}

}
