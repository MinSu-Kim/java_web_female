package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.FuelMapper;
import kr.or.yi.java_web_female.dao.FuelMapperImpl;
import kr.or.yi.java_web_female.dto.Fuel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuelMapperTest extends AbstractTest {
	private FuelMapper dao = FuelMapperImpl.getInstance();
	
	@Test
	public void test01selectFuelByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Fuel searchFuel = new Fuel();
		searchFuel.setCode("lpg");
		
		Fuel newFuel = dao.selectFuelByNo(searchFuel);
		Assert.assertNotNull(newFuel);
	}
	
	@Test
	public void test02selectFuelByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Fuel> list = dao.selectFuelByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03insertFuel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Fuel fuel = new Fuel();
		fuel.setCode("수소");
		fuel.setNo(6);
		int res = dao.insertFuel(fuel);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05deleteFuel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Fuel fuel = new Fuel();
		fuel.setNo(6);
		int res = dao.deleteFuel(fuel);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04updateFuel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Fuel fuel = new Fuel();
		fuel.setNo(6);
		fuel.setCode("수소2");
		int res = dao.updateFuel(fuel);
		Assert.assertEquals(1, res);
	}
}
























