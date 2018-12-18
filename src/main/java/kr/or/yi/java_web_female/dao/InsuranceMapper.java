package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Insurance;

public interface InsuranceMapper {
	List<Insurance> selectInsuranceByAll();

	List<Insurance> selectInsuranceByCarType(String carType);
	
	int insertInsurance(Insurance insurance);
	
	int updateInsurance(Insurance insurance);
	
	int deleteInsurance(Insurance insurance);
}
