package kr.or.yi.java_web_female.service;

import java.util.List;
import java.util.Map;

import kr.or.yi.java_web_female.dao.CarModelMapper;
import kr.or.yi.java_web_female.dao.CarModelMapperImpl;
import kr.or.yi.java_web_female.dao.UserPicMapper;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.UserPic;

public class CarModelService {
	private CarModelMapper dao;
	private UserPicMapper picDao;
	
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
	
	public List<CarModel> SelectCarModelWithWhere(Map<String, String> maps) {
		return dao.SelectCarModelWithWhere(maps);
	}
	
	public UserPic getUserPic(String carCode) {
		return picDao.getUserPic(carCode);
	}
}
