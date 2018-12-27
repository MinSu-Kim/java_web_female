package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.StateCarMapper;
import kr.or.yi.java_web_female.dao.StateCarMapperImpl;
import kr.or.yi.java_web_female.dto.StateCar;

public class StateCarChartService {
	private StateCarMapper dao;

	public StateCarChartService() {
		dao = StateCarMapperImpl.getInstance();
	}
	
	public List<StateCar> selectCountByCarType(){
		return dao.selectCountByCarType();
	}
	
	public List<StateCar> selectCountByBrand(){
		return dao.selectCountByBrand();
	}
	
	
}
