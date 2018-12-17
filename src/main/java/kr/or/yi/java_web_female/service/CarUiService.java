package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.BrandMapper;
import kr.or.yi.java_web_female.dao.BrandMapperImpl;
import kr.or.yi.java_web_female.dao.CarOptionMapper;
import kr.or.yi.java_web_female.dao.CarOptionMapperImpl;
import kr.or.yi.java_web_female.dao.CarTypeMapper;
import kr.or.yi.java_web_female.dao.CarTypeMapperImpl;
import kr.or.yi.java_web_female.dao.FuelMapper;
import kr.or.yi.java_web_female.dao.FuelMapperImpl;
import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;

public class CarUiService {
	private CarOptionMapper optionDao;
	private CarTypeMapper typeDao;
	private FuelMapper fuelDao;
	private BrandMapper brandDao;

	public CarUiService() {
		optionDao = CarOptionMapperImpl.getInstance();
		typeDao = CarTypeMapperImpl.getInstance();
		fuelDao = FuelMapperImpl.getInstance();
		brandDao = BrandMapperImpl.getInstance();
	}
	//카옵션
	public List<CarOption> selectAllCarOption(){
		return optionDao.selectCarOptionByAll();
	}

	public int insertCarOption(CarOption carOption) {
		return optionDao.insertCarOption(carOption);
	}
	
	public int deleteCarOption(CarOption carOption) {
		return optionDao.deleteCarOption(carOption);
	}
	
	public int updateCarOption(CarOption carOption) {
		return optionDao.updateCarOption(carOption);
	}
	
	//차종
	public List<CarType> selectAllCarType(){
		return typeDao.selectCarTypeByAll();
	}
	
	public int insertCarType(CarType carType) {
		return typeDao.insertCarType(carType);
	}
	
	public int deleteCarType(CarType carType) {
		return typeDao.deleteCarType(carType);
	}
	
	public int updateCarType(CarType carType) {
		return typeDao.updateCarType(carType);
	}
	
	//연료
	public List<Fuel> selectAllFuel(){
		return fuelDao.selectFuelByAll();
	}

	public int insertFuel(Fuel fuel) {
		return fuelDao.insertFuel(fuel);
	}
	
	public int deleteFuel(Fuel fuel) {
		return fuelDao.deleteFuel(fuel);
	}
	
	public int updateFuel(Fuel fuel) {
		return fuelDao.updateFuel(fuel);
	}
	
	//브랜드
	public List<Brand> selectAllBrand(){
		return brandDao.selectBrandByAll();
	}
	
	public int insertBrand(Brand brand) {
		return brandDao.insertBrand(brand);
	}
	
	public int deleteBrand(Brand brand) {
		return brandDao.deleteBrand(brand);
	}
	
	public int updateBrand(Brand brand) {
		return brandDao.updateBrand(brand);
	}
	
	
	
}


















