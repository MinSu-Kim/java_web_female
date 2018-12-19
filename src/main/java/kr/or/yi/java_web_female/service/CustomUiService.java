package kr.or.yi.java_web_female.service;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;

public class CustomUiService {
	private CustomerMapper customerDao;

	public CustomUiService() {
		customerDao = CustomerMapperImpl.getInstance();
	}
	
}


