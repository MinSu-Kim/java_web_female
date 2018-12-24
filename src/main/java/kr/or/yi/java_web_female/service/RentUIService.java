package kr.or.yi.java_web_female.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.yi.java_web_female.dao.CarModelMapper;
import kr.or.yi.java_web_female.dao.CarModelMapperImpl;
import kr.or.yi.java_web_female.dao.CarOptionMapper;
import kr.or.yi.java_web_female.dao.CarOptionMapperImpl;
import kr.or.yi.java_web_female.dao.CarTypeMapper;
import kr.or.yi.java_web_female.dao.CarTypeMapperImpl;
import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.InsuranceMapper;
import kr.or.yi.java_web_female.dao.InsuranceMapperImpl;
import kr.or.yi.java_web_female.dao.RentMapper;
import kr.or.yi.java_web_female.dao.RentMapperImpl;
import kr.or.yi.java_web_female.dao.UserPicMapper;
import kr.or.yi.java_web_female.dao.UserPicMapperImpl;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.UserPic;

public class RentUIService {
	private CustomerMapper customerDao;
	private CarTypeMapper carTypeDao;
	private CarModelMapper carModelDao;
	private CarOptionMapper carOptionDao;
	private InsuranceMapper insuranceDao;
	private RentMapper rentDao;
	private UserPicMapper userPicDao;
	
	public RentUIService() {
		customerDao = CustomerMapperImpl.getInstance();
		carTypeDao = CarTypeMapperImpl.getInstance();
		carModelDao = CarModelMapperImpl.getInstance();
		carOptionDao = CarOptionMapperImpl.getInstance();
		insuranceDao = InsuranceMapperImpl.getInstance();
		rentDao = RentMapperImpl.getInstance();
		userPicDao = UserPicMapperImpl.getInstance();
	}
	
	public List<Customer> selectCustomer(Customer name) throws SQLException{
		return customerDao.selectCustomerByName(name);
	}
	
	//이벤트
	public List<Customer> selectCustomerByCode(Customer customer){
		return customerDao.selectCustomerByCode(customer);
	}
	
	public List<Customer> selectCustomerFullByCode(Customer customer){
		return customerDao.selectCustomerByCode(customer);
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
	
	public List<CarOption> selectAllCarOptions(){
		return carOptionDao.selectCarOptionByAll();
	}
	
	public List<Insurance> selectInsuranceByCarType(String carType){
		return insuranceDao.selectInsuranceByCarType(carType);
	}
	
	public String nextRentNo() {
		return rentDao.getNextRentNo();
	}
	
	public UserPic getUserPic(String carCode) {
		return userPicDao.getUserPic(carCode);
	}
}
