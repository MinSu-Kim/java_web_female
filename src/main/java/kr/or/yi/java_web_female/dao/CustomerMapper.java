package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;

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
	// 추가
	List<Customer> selectCustomerByCode(Customer customer);
	
///////////////////////// 트랜잭션 처리 //////////////////////////
	int insertCustomerJoin(Customer customer, CustomEvent customEvent);
///////////////////////// 트랜잭션 처리 //////////////////////////
	int deleteCustomerEvent(Customer customer, CustomEvent customEvent);
}
