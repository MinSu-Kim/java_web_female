package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.GradeMapper;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.StateCar;

public class ChartService {
	private CustomerMapper cusDao;
	private GradeMapper gradDao;
	
	public ChartService() {
		cusDao = CustomerMapperImpl.getInstance();
	}
	
	public List<StateCar> chartAddr() {
		return cusDao.chartAddr();
	}
	
	public Customer selectCustomerById(Customer customer) {
		return cusDao.selectCustomerById(customer);
	}
	public List<Customer> selectCustomerByAll() {
		return cusDao.selectCustomerByAll();
	}
	
	public List<Grade> selectGradeByAll(){
		return gradDao.selectGradeByAll();
	}
	public List<StateCar> chartGrade(){
		return cusDao.chartGrade();
	}
	

}
