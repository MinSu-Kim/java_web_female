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
		typeDao = new CarTypeMapperImpl();
		fuelDao = FuelMapperImpl.getInstance();
		brandDao = BrandMapperImpl.getInstance();
	}
	
	public List<CarOption> selectAllCarOption(){
		return optionDao.selectCarOptionByAll();
	}
	
	public List<CarType> selectAllCarType(){
		return typeDao.selectCarTypeByAll();
	}
	
	public List<Fuel> selectAllFuel(){
		return fuelDao.selectFuelByAll();
	}
	
	public List<Brand> selectAllBrand(){
		return brandDao.selectBrandByAll();
	}
	
	public int insertFuel(Fuel fuel) {
		return fuelDao.insertFuel(fuel);
	}
	
	
}
