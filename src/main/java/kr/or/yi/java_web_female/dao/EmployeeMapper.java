package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Employee;

public interface EmployeeMapper {
	Employee selectEmployeeByNo(Employee employee);
	List<Employee> selectEmployeeByAll();
	
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	int updateEmployee(Employee employee);
	
	int selectEmployeeById(Employee employee);
	Employee selectEmployeeByPw(Employee employee);
}
