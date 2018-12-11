package kr.or.yi.java_web_female.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;

public class RentUIService {
	private CustomerMapper dao;

	public RentUIService() {
		dao = new CustomerMapperImpl();
	}
	
	public List<Customer> selectCustomer(Customer name) throws SQLException{
		return dao.selectCustomerByName(name);
	}
	
	public List<Customer> selectAllCustomers() throws SQLException{
		return dao.selectCustomerByAll();
	}
	
}
