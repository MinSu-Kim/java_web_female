package kr.or.yi.java_web_female;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.dto.Grade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerMapperTest extends AbstractTest {

	private CustomerMapper dao = CustomerMapperImpl.getInstance();
	private String orderDate;

	@Test
	public void test01SelectCustomerByName() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Customer searchCustomer = new Customer();
		searchCustomer.setName("김영희");
		List<Customer> list = dao.selectCustomerByName(searchCustomer);
		Assert.assertNotNull(list);
	}

	@Test
	public void test02SelectCustomerByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Customer> list = dao.selectCustomerByAll();
		Customer i = list.get(1);
		System.out.println(i);
		Assert.assertNotNull(list);
	}

	@Test
	public void test03selectCustomerById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Customer searchId = new Customer();
		searchId.setId("qwer12");
		Customer selectCustomer = dao.selectCustomerById(searchId);
		Assert.assertNotNull(selectCustomer);
	}

	@Test
	public void test04insertCustomer() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Customer customer = new Customer();
		customer.setCode(dao.nextCode());
		customer.setId("psw2701");
		customer.setPasswd("password");
		customer.setName("박수완");
		customer.setZipCode("21236");
		customer.setAddress("대구");
		customer.setPhone("010-5757-5959");
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 13);
		customer.setDob(cal.getTime());

		customer.setEmail("psw2701@naver.com");

		Employee employee = new Employee();
		employee.setCode("E001");
		customer.setEmpCode(employee);

		customer.setLicense("2종보통");

		Grade grade = new Grade();
		grade.setCode("G001");
		customer.setGradeCode(grade);

		customer.setRentCnt(0);

		int res = dao.insertCustomer(customer);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05nextCustomerCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int cnt = dao.nextCustomerCode();
		Assert.assertNotEquals(0, cnt);
	}

	@Test
	public void test06nextCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		String cnt = dao.nextCode();
		System.out.println("cnt " + cnt);
		Assert.assertNotNull(cnt);
	}

	@Test
	public void test07selectCustomerByPw() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Customer searchPw = new Customer();
		searchPw.setId("asd132");
		searchPw.setPasswd("rootroot");
		Customer selCustomer = dao.selectCustomerByPw(searchPw);
		Assert.assertNotNull(selCustomer);
	}

	@Test
	public void test08selectCustomerByCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Customer searchPw = new Customer();
		searchPw.setCode("C001");
		List<Customer> cusList = dao.selectCustomerByCode(searchPw);
		for (Customer c : cusList) {
			System.out.println(c);
		}
		Assert.assertNotNull(cusList);
	}

	@Test
	public void test04updateCustomer() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Customer customer = new Customer();

		customer.setCode("C009");
		customer.setId("psw2701");
		customer.setPasswd("password");
		customer.setName("박수완");
		customer.setZipCode("15426");
		customer.setAddress("대구");
		customer.setPhone("010-5757-5959");
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 12, 20);
		customer.setDob(cal.getTime());
		customer.setEmail("qwerasdf@naver.com");
		
		Employee employee = new Employee();
		employee.setCode("E001");
		customer.setEmpCode(employee);
		
		customer.setLicense("2종 보통");
		
		Grade grade = new Grade();
		grade.setCode("G001");
		customer.setGradeCode(grade);
		customer.setRentCnt(5);
		
		int res = dao.updateCustomer(customer);
		Assert.assertSame(1, res);

	}

	@Test
	public void test11JoinTransactionTest03() {

		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Customer customer = new Customer();
		customer.setCode(dao.nextCode());
		customer.setId("java");
		customer.setPasswd("rootroot");
		customer.setName("자바");
		customer.setZipCode("51689");
		customer.setAddress("대구");
		customer.setPhone("053-555-1333");
		customer.setEmail("psw2701@naver.com");
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 12, 20);
		customer.setDob(cal.getTime());

		CustomEvent customEvent = new CustomEvent("EVT1", customer.getCode(), false);

		dao.insertCustomerJoin(customer, customEvent);
	}

	@Test
	public void test12DeleteTransactionTest03() {

		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Customer customer = new Customer();
		customer.setCode(dao.nextCode());

		CustomEvent customEvent = new CustomEvent("EVT1", customer.getCode(), false);

		dao.deleteCustomerEvent(customer, customEvent);
	}
	@Test
	public void test13searchId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Customer searchId = new Customer();
		searchId.setPhone("010-0000-7777");
		searchId.setEmail("abc@gmail.com");
		Customer selectCustomer = dao.searchId(searchId);
		Assert.assertNotNull(selectCustomer);
		
	}
	@Test
	public void test14changePw() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Customer customer = new Customer();
		customer.setPhone("010-0000-7777");
		customer.setEmail("abc@gmail.com");
		customer.setPasswd("password");
		int res = dao.changePw(customer);
		Assert.assertEquals(1, res);
	}
}
