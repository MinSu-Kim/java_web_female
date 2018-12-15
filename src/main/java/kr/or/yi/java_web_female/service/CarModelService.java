package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CarModelMapper;
import kr.or.yi.java_web_female.dao.CarModelMapperImpl;
import kr.or.yi.java_web_female.dto.CarModel;

public class CarModelService {
	private CarModelMapper dao;
	
	public CarModelService() {
		dao = CarModelMapperImpl.getInstance();
	}
	
	public CarModel selectCarModelByNo(CarModel carModel) {
		return dao.selectCarModelByNo(carModel);
	}
	
	public List<CarModel> selectCarModelByAll() {
		return dao.selectCarModelByAll();
	}
	
	public int insertCarModel(CarModel carModel) {
		return dao.insertCarModel(carModel);
	}
	
	public int updateCarModel(CarModel carModel) {
		return dao.updateCarModel(carModel);
	}
	
	public int deleteCarModel(CarModel carModel) {
		return dao.deleteCarModel(carModel);
	}
}
