package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CarOption;

public interface CarOptionMapper {
	CarOption selectCarOptionByNo(CarOption carOption);
	List<CarOption> selectCarOptionByAll();
	int insertCarOption(CarOption carOption);
	int updateCarOption(CarOption carOption);
	int deleteCarOption(CarOption carOption);
	
	int nextOptionNo();
}
