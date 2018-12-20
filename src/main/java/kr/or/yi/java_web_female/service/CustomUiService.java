package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;


public class CustomUiService {
	private CustomerMapper customerDao;

	public CustomUiService() {
		customerDao = CustomerMapperImpl.getInstance();
	}
	
	public List<Customer> selectCustomerByAll(){
		return customerDao.selectCustomerByAll();
	}
	public int insertCustomer(Customer customer){
		return customerDao.insertCustomer(customer);
	}
	public int updateCustomer(Customer customer){
		return customerDao.updateCustomer(customer);
	}
	public int deleteCustomer(Customer customer){
		return customerDao.deleteCustomer(customer);
	}

	
}


