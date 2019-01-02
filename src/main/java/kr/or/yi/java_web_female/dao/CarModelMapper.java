package kr.or.yi.java_web_female.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

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
	
	List<CarModel> SelectCarModelWithWhere(Map<String, String> map);
	
	String nextCarCode();
	
	
	// rent 등록 시 대여중으로변경
	@Update("update car_model set is_rent = 1, rent_cnt = rent_cnt + 1 where car_code = #{carCode}")
	int updateCarModelRent(CarModel carModel);
	
	///////
	List<CarModel> selectCarModel();
}
