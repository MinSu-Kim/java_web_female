package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomEventMapperImpl;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;

public class JoinUiService {
	private CustomerMapperImpl cusDao;
	private CustomEventMapperImpl cEvtDao;
/*	private GradeMapperImpl gradeDao;
	private EmployeeMapperImpl empDao;*/
	
	public JoinUiService() {
		cusDao = CustomerMapperImpl.getInstance();
		cEvtDao = CustomEventMapperImpl.getInstance();
/*		empDao = EmployeeMapperImpl.getInstance();
		gradeDao = GradeMapperImpl.getInstance();*/
	}

	public int addcus(Customer customer, CustomEvent customEvent) {
		int res =  cusDao.insertCustomer(customer);
		int resw = cEvtDao.insertCustomEvent(customEvent);
		return (res + resw)==2?1:0;
	}

	public List<Customer> selectCustomerByAll() {
		return cusDao.selectCustomerByAll();
	}
	
	public int nextCustomerCode() {
		return cusDao.nextCustomerCode();
	}
	
	public String getNextCustomerCode() {
		return cusDao.nextCode();
	}

	public Customer selectCustomerById(Customer customer) {
		return cusDao.selectCustomerById(customer);
	}
	
}
