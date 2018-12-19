package kr.or.yi.java_web_female;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.RentMapper;
import kr.or.yi.java_web_female.dao.RentMapperImpl;

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
	

}
