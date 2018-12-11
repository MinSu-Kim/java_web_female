package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.CustomerMapper;
import kr.or.yi.java_web_female.dao.CustomerMapperImpl;
import kr.or.yi.java_web_female.dto.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerMapperTest extends AbstractTest {
	private CustomerMapper dao = new CustomerMapperImpl();
	
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

}
