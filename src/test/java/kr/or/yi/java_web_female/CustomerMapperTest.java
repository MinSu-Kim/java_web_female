package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.w3c.dom.css.CSSUnknownRule;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerMapperTest extends AbstractTest {

	private CustomerMapper dao =  CustomerMapperImpl.getInstance();


	
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
		int list = dao.selectCustomerById(searchId);
		
		Assert.assertEquals(1, list);
	}
	
	@Test
	public void test04insertCustomer() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Customer customer = new Customer();
/*		String code = String.format("C%03d", dao.nextCustomerCode());
		customer.setCode(code);*/
		customer.setCode(dao.nextCode());
		customer.setId("psw2701");
		customer.setPasswd("password");
		customer.setName("박수완");
		customer.setAddress("대구");
		customer.setPhone("010-5757-5959");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 13);
		customer.setDob(cal.getTime());
		
		customer.setEmail("psw2701@naver.com");
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
		searchPw.setPasswd("rootroot");
		int list = dao.selectCustomerByPw(searchPw);
		
		Assert.assertEquals(1, list);
	}
}
