package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dao.EmployeeMapper;
import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dao.GradeMapper;
import kr.or.yi.java_web_female.dao.GradeMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;


public class CustomUiService {
	private CustomerMapper customerDao;
	private GradeMapper gradeDao;
	private EmployeeMapper empDao;
	
	public CustomUiService() {
		customerDao = CustomerMapperImpl.getInstance();
		gradeDao = GradeMapperImpl.getInstance();
		empDao = EmployeeMapperImpl.getInstance();
	}
	
	public List<Customer> selectCustomerByAll(){
		return customerDao.selectCustomerByAll();
	}
	public int insertCustomer(Customer customer){
		return customerDao.insertCustomer(customer);
	}
	public int updateCustomer(Customer customer){
		return customerDao.updateCustomer(customer);
	}
	public void deleteCustomerEvent(Customer customer, CustomEvent customEvent){
		customerDao.deleteCustomerEvent(customer, customEvent);
	}

	public Grade getGradeByName(Grade gradeName) {
		return gradeDao.selectGradeByName(gradeName);
	}
	
	public Employee getEmployeeByNo(Employee employee) {
		return empDao.selectEmployeeByNo(employee);
	}
	
	public List<Employee> getEmpList(){
		return empDao.selectEmployeeByAll();
	}
	
	public List<Grade> getGradeList(){
		return gradeDao.selectGradeByAll();
	}
}


