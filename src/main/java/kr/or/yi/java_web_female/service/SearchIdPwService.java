package kr.or.yi.java_web_female.service;

import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;

public class SearchIdPwService {
	private CustomerMapperImpl cusDao;

	public SearchIdPwService() {
		cusDao = CustomerMapperImpl.getInstance();
	}
	
	public Customer searchId(Customer customer) {
		return cusDao.searchId(customer);
	}
	
	public String getRandPw() {
		return cusDao.getRandomPassword();
	}
	
	public int changePw(Customer customer) {
		return cusDao.changePw(customer);
	}
}

