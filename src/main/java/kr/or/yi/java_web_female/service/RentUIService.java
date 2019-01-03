package kr.or.yi.java_web_female.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
import kr.or.yi.java_web_female.dao.TotalPriceMapper;
import kr.or.yi.java_web_female.dao.TotalPriceMapperImpl;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.dto.UserPic;
import kr.or.yi.java_web_female.dto.totalPrice;

public class RentUIService {
	private CustomerMapper customerDao;
	private CarTypeMapper carTypeDao;
	private CarModelMapper carModelDao;
	private CarOptionMapper carOptionDao;
	private InsuranceMapper insuranceDao;
	private RentMapper rentDao;
	private UserPicMapper userPicDao;
	private TotalPriceMapper totalPriceDao;
	
	
	public RentUIService() {
		customerDao = CustomerMapperImpl.getInstance();
		carTypeDao = CarTypeMapperImpl.getInstance();
		carModelDao = CarModelMapperImpl.getInstance();
		carOptionDao = CarOptionMapperImpl.getInstance();
		insuranceDao = InsuranceMapperImpl.getInstance();
		rentDao = RentMapperImpl.getInstance();
		userPicDao = UserPicMapperImpl.getInstance();
		totalPriceDao = TotalPriceMapperImpl.getInstance();
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
	
	public void insertRent(Rent rent) {
		rentDao.insertRent(rent);
	}
	
/*	public void insertRent(Rent rent, Map<String, Object> map) {
		rentDao.insertRent(rent, map);
	}*/
	
	public List<Rent> selectRentByAll(){
		return rentDao.selectRentByAll();
	}
	
	public List<Rent> selectRentAll(){
		return rentDao.selectRentAll();
	}
	
	//반납
	public int changeIsReturn(Rent rent) {
		return rentDao.changeisReturn(rent);
	}
	
	//////////////
	public List<CarModel> selectCarModel(){
		return carModelDao.selectCarModel();
	}
	
	public List<Rent> FilterRentInfo(Map<String, String> map){
		return rentDao.FilterRentInfo(map);
	}
	
	public List<StateCar> selectCountRentByMonth(){
		return rentDao.selectCountRentByMonth();
	}
	
	public List<StateCar> selectCountRentByMonthWithCarType(String carType){
		return rentDao.selectCountRentByMonthWithCarType(carType);
	}
	
	public List<StateCar> selectCountRentByMonthWithBrand(String brand){
		return rentDao.selectCountRentByMonthWithBrand(brand);
	}
	
	public List<StateCar> selectCarOptionsWithRentCode(){
		return rentDao.selectCarOptionsWithRentCode();
	}
	
	//매출액 통계
	public List<totalPrice> selectTotalPrice(){
		return totalPriceDao.selectTotalPrice();
	}
	
	//고객 대여내역
	public List<Rent> selectRentAllByCustomerCode(String customerCode){
		return rentDao.selectRentAllByCustomerCode(customerCode);
	}
	
	//고객통계1
	public List<StateCar> selectPreference(String customerCode){
		return rentDao.selectPreference(customerCode);
	}
	
	//고객통계2
	public List<StateCar> selectCarTypeStat(String customerCode){
		return rentDao.selectCarTypeStat(customerCode);
	}
	
/*	//통계 테스트
	public List<StateCar> selectCarTypeCarNameStat(Map<String, String> map){
		return rentDao.selectCarTypeCarNameStat(map);
	}*/
}
