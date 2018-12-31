package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.StateCarMapper;
import kr.or.yi.java_web_female.dao.StateCarMapperImpl;
import kr.or.yi.java_web_female.dto.StateCar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StateCarMapperTest extends AbstractTest {
	private StateCarMapper dao = StateCarMapperImpl.getInstance();
	
	@Test
	public void test01selectCountByCarType() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<StateCar> list = dao.selectCountByCarType();
		Assert.assertNotNull(list);	
	}
	
	@Test
	public void test02selectCountByBrand() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<StateCar> list = dao.selectCountByBrand();
		Assert.assertNotNull(list);	
	}

}
