package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.Insurance;

public interface InsuranceMapper {
	List<Insurance> selectInsuranceByAll();

	Insurance selectInsuranceByCode(Insurance insurance);
	
	int insertInsurance(Insurance insurance);
	
	int updateInsurance(Insurance insurance);
	
	int deleteInsurance(Insurance insurance);
}
