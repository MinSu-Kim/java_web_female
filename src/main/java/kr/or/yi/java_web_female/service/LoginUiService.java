package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.exception.LoginFailException;

public class LoginUiService {
	private EmployeeMapperImpl empDao;
	private CustomerMapperImpl cusDao;

	public LoginUiService() {
		cusDao = CustomerMapperImpl.getInstance();
		empDao = EmployeeMapperImpl.getInstance();
	}

/*	
	public int selectEmployeeById(Employee employee) {
		return empDao.selectEmployeeById(employee);
	}

	public Customer selectCustomerById(Customer customer) {
		return cusDao.selectCustomerById(customer);
	}
*/	
	public Customer selectCustomerByPw(Customer customer) throws LoginFailException {
		Customer resCustomer = cusDao.selectCustomerByPw(customer);
		if (resCustomer == null) {
			throw new LoginFailException("아이디와 비밀번호를 다시 확인해 주세요.");
		}
		return resCustomer;
	}
	
	public Employee selectEmployeeByPw(Employee employee) throws LoginFailException {
		Employee resEmp =  empDao.selectEmployeeByPw(employee);
		if (resEmp == null) {
			throw new LoginFailException("아이디와 비밀번호를 다시 확인해 주세요.");
		}
		return resEmp;
	}
	
	public List<Customer> selectCustomerByCode(Customer customer) {
		return cusDao.selectCustomerByCode(customer);
	}
}
