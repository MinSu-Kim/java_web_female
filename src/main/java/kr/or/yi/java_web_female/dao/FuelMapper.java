package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Fuel;

public interface FuelMapper {
	
	Fuel selectFuelByNo(Fuel fuel);
	List<Fuel> selectFuelByAll();
	int insertFuel(Fuel fuel);
	int updateFuel(Fuel fuel);
	int deleteFuel(Fuel fuel);
	
	int nextFuelNo();
}
