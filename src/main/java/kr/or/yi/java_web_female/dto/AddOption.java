package kr.or.yi.java_web_female.dto;

public class AddOption {
	private CarOption optionId; //erd에서 변수명은 option_id
	private CarModel carCode; //erd에서 변수명은 car_code
	
	public CarOption getOptionId() {
		return optionId;
	}
	public void setOptionId(CarOption optionId) {
		this.optionId = optionId;
	}
	public CarModel getCarCode() {
		return carCode;
	}
	public void setCarCode(CarModel carCode) {
		this.carCode = carCode;
	}
	
	@Override
	public String toString() {
		return "AddOption [optionId=" + optionId + ", carCode=" + carCode + "]";
	}
	
	

}
