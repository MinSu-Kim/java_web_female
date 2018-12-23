package kr.or.yi.java_web_female;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.RentMapper;
import kr.or.yi.java_web_female.dao.RentMapperImpl;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.dto.Rent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentMapperTest extends AbstractTest {
	private RentMapper dao = RentMapperImpl.getInstance();
	
	@Test
	public void test01GetNextRentNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		String nextRentNo = dao.getNextRentNo();
		System.out.println(nextRentNo);
		Assert.assertNotNull(nextRentNo);
	}
	
	@Test
	public void test02InsertRent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Rent rent = new Rent();
		rent.setCode(dao.getNextRentNo());
		rent.setStartDate("2018-12-23");
		rent.setStartTime("12:00:00");
		rent.setEndDate("2018-12-24");
		rent.setEndTime("12:00:00");
		rent.setReturn(false);
		rent.setTotalPrice(40000);
		rent.setCarCode(new CarModel("V002"));
		Customer customer = new Customer();
		customer.setCode("C006");
		rent.setCustomerCode(customer);
		rent.setInsuranceCode(new Insurance("I000"));
		rent.seteRate(5);
		rent.setOptPrice(5000);
		
		int res = dao.insertRent(rent);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test03Procedure() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<>();
		map.put("custom_code", "C006");
		map.put("rent_code", "R005");
		map.put("carCode", "V002");
		map.put("isGrade", 0);
		
		dao.procedureRent(map);
//		Assert.assertNotNull(map);
	}
	
/*	@Test
	public void test04Procedure2() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<>();
		map.put("custom_code", "C005");
		map.put("rent_code", "R005");
		map.put("carCode", "V002");
		map.put("isGrade", 1);
		
		dao.procedureRent2(map);
//		Assert.assertNotNull(map);
	}*/

}
