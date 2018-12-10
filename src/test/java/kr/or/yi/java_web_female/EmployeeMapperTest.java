package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.EmployeeMapper;
import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dto.Employee;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmployeeMapperTest extends AbstractTest {
	private EmployeeMapper dao = new EmployeeMapperImpl();

	@Test
	public void test01selectEmployeeByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee searchEmp = new Employee();
		searchEmp.setCode("E001");

		Employee searchedEmp = dao.selectEmployeeByNo(searchEmp);
		Assert.assertNotNull(searchedEmp);
	}

	@Test
	public void test02selectEmployeeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee searchEmp = new Employee();
		searchEmp.setCode("E001");
		List<Employee> empList = dao.selectEmployeeByAll();
		Assert.assertNotNull(empList);
	}

	/*@Test
	public void test03insertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee();
		Title title = new Title();
		employee.setCode("E003");
		employee.setName("나인턴");
		employee.setPhone("010-4505-8465");
		employee.setPasswd("");
		
		

	}*/
	
	/*@Test
	public void test05deleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee();
		employee.setCode("E003");
		int res = dao.deleteEmployee(employee);
		Assert.assertEquals(1, res);
	}*/
	
}