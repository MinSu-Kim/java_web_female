package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.EmployeeMapper;
import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dto.Employee;

public class EmployeeUiService {
	private EmployeeMapper empDao;

	public EmployeeUiService() {
		empDao = EmployeeMapperImpl.getInstance();
	}
	
	public Employee selectEmployeeByNo(Employee employee) {
		return empDao.selectEmployeeByNo(employee);
	}
	public List<Employee> selectEmployeeByAll(){
		return empDao.selectEmployeeByAll();
	}
	
	public int insertEmployee(Employee employee){
		return empDao.insertEmployee(employee);
	}
	public int deleteEmployee(Employee employee){
		return empDao.deleteEmployee(employee);
	}
	public int updateEmployee(Employee employee){
		return empDao.updateEmployee(employee);
	}
	
	
}
