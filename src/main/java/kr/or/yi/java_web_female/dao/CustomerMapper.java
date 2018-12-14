package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Customer;

public interface CustomerMapper {
	List<Customer> selectCustomerByName(Customer customer);
	
	List<Customer> selectCustomerByAll();
	
	int selectCustomerById(Customer customer);
	
	int insertCustomer(Customer customer);
	
	
	int nextCustomerCode();
	String nextCode();
	/*int selectCustomerByPw*/
}
