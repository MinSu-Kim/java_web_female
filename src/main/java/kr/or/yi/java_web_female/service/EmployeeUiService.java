package kr.or.yi.java_web_female.service;

import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;

public class EmployeeUiService {
	private EmployeeMapperImpl empDao;
	
	
	public int selectEmployeeById (Employee employee) {
		return empDao.selectEmployeeById(employee);
	}
	
	
	public int selectEmployeeByPw(Employee employee) {
		return empDao.selectEmployeeByPw(employee);
	}
}
