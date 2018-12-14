package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.GradeMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;

public class CustomerUiService {
	private CustomerMapperImpl cusDao;
	private GradeMapperImpl gradeDao;
	
	public CustomerUiService() {
		cusDao = CustomerMapperImpl.getInstance();
		gradeDao = GradeMapperImpl.getInstance();
	}

	public int addcus(Customer customer) {
		return cusDao.insertCustomer(customer);

	}

	public List<Customer> selectCustomerByAll() {
		return cusDao.selectCustomerByAll();
	}
	
	public int selectCustomerById(Customer customer) {
		return cusDao.selectCustomerById(customer);
	}

	public int nextCustomerCode() {
		return cusDao.nextCustomerCode();
	}
	
	/*public int selectCustomerByPw(Customer customer) {
		return cusDao.selectCustomerByPw(customer);
	}
	*/

	
	
}
