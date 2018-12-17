package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomEventMapperImpl;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.GradeMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;

public class CustomerUiService {
	private CustomerMapperImpl cusDao;
	private CustomEventMapperImpl cEvtDao;
	private GradeMapperImpl gradeDao;
	
	
	public CustomerUiService() {
		cusDao = CustomerMapperImpl.getInstance();
		gradeDao = GradeMapperImpl.getInstance();
		cEvtDao = CustomEventMapperImpl.getInstance();
	}

	public int addcus(Customer customer, CustomEvent customEvent) {
		int res =  cusDao.insertCustomer(customer);
		int resw = cEvtDao.insertCustomEvent(customEvent);
		return (res + resw)==2?1:0;
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
	
	public String getNextCustomerCode() {
		return cusDao.nextCode();
	}
	
	public int selectCustomerByPw(Customer customer) {
		return cusDao.selectCustomerByPw(customer);
	}
	

	
	
}
