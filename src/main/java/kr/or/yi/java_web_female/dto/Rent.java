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
	//고객코드
	private Insurance insuranceCode;	//보험코드
	//이벤트 할인율
	private int optPrice;	//옵션비용
	
	
}
