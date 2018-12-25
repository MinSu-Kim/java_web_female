package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.CustomEventMapper;
import kr.or.yi.java_web_female.dao.CustomEventMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Rent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerEventMapperTest extends AbstractTest {

	private CustomEventMapper dao = CustomEventMapperImpl.getInstance();

	@Test
	public void test01selectCustomEventByCustomCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<CustomEvent> customEvents = dao.selectCustomEventByCustomCode("C001");
		System.out.println(customEvents);
		System.out.println("size : " + customEvents.size());
		Assert.assertNotNull(customEvents);
	}
	
	@Test
	public void teset02UpdateSetUse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Rent rent = new Rent();
		rent.seteCode("EVT1");
		Customer c = new Customer();
		c.setCode("C005");
		rent.setCustomerCode(c);
		int res = dao.updateSetUse(rent);
		Assert.assertEquals(1, res);
	}

}
