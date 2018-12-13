package kr.or.yi.java_web_female.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.CloseableThreadContext.Instance;

import kr.or.yi.java_web_female.dao.CarModelMapper;
import kr.or.yi.java_web_female.dao.CarModelMapperImpl;
import kr.or.yi.java_web_female.dao.CarTypeMapper;
import kr.or.yi.java_web_female.dao.CarTypeMapperImpl;
import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Customer;

public class RentUIService {
	private CustomerMapper customerDao;
	private CarTypeMapper carTypeDao;
	private CarModelMapper carModelDao;
	
	public RentUIService() {
		customerDao = CustomerMapperImpl.getInstance();
		carTypeDao = CarTypeMapperImpl.getInstance();
		carModelDao = CarModelMapperImpl.getInstance();
	}
	
	public List<Customer> selectCustomer(Customer name) throws SQLException{
		return customerDao.selectCustomerByName(name);
	}
	
	public List<Customer> selectAllCustomers() throws SQLException{
		return customerDao.selectCustomerByAll();
	}
	
	public List<CarType> selectAllCarTypes(){
		return carTypeDao.selectCarTypeByAll();
	}
	
	public List<CarModel> selectAllCarModels(CarType carType){
		return carModelDao.selectCarModelByCarType(carType);
	}
	
}
