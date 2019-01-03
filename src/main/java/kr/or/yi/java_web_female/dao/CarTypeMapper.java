package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CarType;

public interface CarTypeMapper {
	
	CarType selectCarTypeByNo(CarType carType);
	List<CarType> selectCarTypeByAll();
	int insertCarType(CarType carType);
	int updateCarType(CarType carType);
	int deleteCarType(CarType carType);
	
	String nextTypeCode();
}
