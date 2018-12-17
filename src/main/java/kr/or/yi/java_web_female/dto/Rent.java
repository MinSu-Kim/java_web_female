package kr.or.yi.java_web_female.dto;

import java.util.Date;

public class Rent {
	private String code;	//대여코드
	private String startDate;	//대여시작일
	private String startTime; //대여시작시간
	private String endDate;	//대여반납일
	private String endTime;	//대여반납시간
	private boolean isReturn;	//반납여부
	private int totalPrice;	//대여총비용(DB -> basic_price)
	private CarModel carCode;	//차량코드
	private Customer customerCode;	//고객코드
	private Insurance insuranceCode;	//보험코드
	private Event eRate;	//이벤트 할인율
	private int optPrice;	//옵션비용
	
	public Rent() {
		// TODO Auto-generated constructor stub
	}

	public Rent(String code, String startDate, String startTime, String endDate, String endTime, boolean isReturn,
			int totalPrice, CarModel carCode, Customer customerCode, Insurance insuranceCode, Event eRate,
			int optPrice) {
		super();
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
		return "Rent [code=" + code + ", startDate=" + startDate + ", startTime=" + startTime + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", isReturn=" + isReturn + ", totalPrice=" + totalPrice + ", carCode="
				+ carCode + ", customerCode=" + customerCode + ", insuranceCode=" + insuranceCode + ", eRate=" + eRate
				+ ", optPrice=" + optPrice + "]";
	}
}
