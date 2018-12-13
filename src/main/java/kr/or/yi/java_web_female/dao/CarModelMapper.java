package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;

public interface CarModelMapper {

	CarModel selectCarModelByNo(CarModel carModel);
	List<CarModel> selectCarModelByAll();
	int insertCarModel(CarModel carModel);
	int updateCarModel(CarModel carModel);
	int deleteCarModel(CarModel carModel);
	
	List<CarModel> selectCarModelWithCarOptionByAll();
	List<CarModel> selectCarModelWithCarOptionByCode(CarModel carModel);

	List<CarModel> selectCarModelByCarType(CarType carType);
}
