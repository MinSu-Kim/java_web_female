package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.EmployeeMapper;
import kr.or.yi.java_web_female.dao.EmployeeMapperImpl;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmployeeMapperTest extends AbstractTest {
	private EmployeeMapper dao = EmployeeMapperImpl.getInstance();

	/*@Test
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
		List<Employee> empList = dao.selectEmployeeByAll();
		Assert.assertNotNull(empList);
	}

	@Test
	public void test03selectEmployeeById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Employee searchId = new Employee();
		searchId.setCode("E001");
		int list = dao.selectEmployeeById(searchId);

		Assert.assertEquals(1, list);
	}

	@Test
	public void test04selectEmployeeByPw() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Employee searchPw = new Employee();
		searchPw.setCode("E001");
		searchPw.setPasswd("rootroot");
		Employee resEmp = dao.selectEmployeeByPw(searchPw);
		System.out.println(resEmp);
		Assert.assertNotNull(resEmp);

	}*/

	@Test
	public void test05insertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee();
		
		employee.setName("나인턴");
		employee.setPhone("010-4505-8465");
		employee.setPasswd("zzzzz");

		//employee.settCode(new Title("T001", "매니저", true));
		int res =dao.insertEmployee(employee);
		Assert.assertEquals(1, res);
	}
	
	/*@Test
	public void test06updateGrade() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee();
		employee.setCode("E003");
		employee.setName("나인턴");
		employee.setPhone("010-4505-8465");
		employee.setPasswd("");

		int res = dao.updateEmployee(employee);
		Assert.assertSame(1, res);

	}

	@Test
	public void test07deleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee();
		employee.setCode("E003");
		int res = dao.deleteEmployee(employee);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test02InsertEmployee() throws SQLException {
		Employee newEmp = new Employee("E017003","너부장",new Title("T001"),4000000,Gender.FEMALE,new Department("D002"),new Date());
		int row = dao.insertEmployee(newEmp);
		LogUtil.prnLog("Insert row :" + row);
		Assert.assertEquals(1, row);
		test01selectEmployeeByAll();
	}
*/
}
