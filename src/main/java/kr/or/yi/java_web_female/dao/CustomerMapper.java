package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Grade;

public interface CustomerMapper {
	List<Customer> selectCustomerByName(Customer customer);
	
	List<Customer> selectCustomerByAll();
	
	Customer selectCustomerById(Customer customer);
	
	int insertCustomer(Customer customer);
	
	int updateCustomer(Customer customer);
	
	int deleteCustomer(Customer customer);
	
	int nextCustomerCode();
	
	String nextCode();
	
	Customer selectCustomerByPw(Customer customer);
	
	//추가
	List<Customer> selectCustomerByCode(Customer customer);
}
