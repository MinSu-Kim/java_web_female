package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.CarTypeMapper;
import kr.or.yi.java_web_female.dao.CarTypeMapperImpl;
import kr.or.yi.java_web_female.dto.CarType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarTypeMapperTest extends AbstractTest {
	private CarTypeMapper dao = new CarTypeMapperImpl();
	
	
	@Test
	public void test01selectCarTypeByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarType searchCarType = new CarType();
		searchCarType.setCode("S1");
		
		CarType newCarType = dao.selectCarTypeByNo(searchCarType);
		Assert.assertNotNull(newCarType);
	}
	
	@Test
	public void test02selectCarTypeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<CarType> list = dao.selectCarTypeByAll();
		Assert.assertNotNull(list);
		
	}
	
	@Test
	public void test03insertCarType() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarType carType = new CarType();
		carType.setCode("S7");
		carType.setType("버스");
		
		int res = dao.insertCarType(carType);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04updateCarType() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarType carType = new CarType();
		carType.setCode("S7");
		carType.setType("고급");
		
		int res = dao.updateCarType(carType);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05deleteCarType() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarType carType = new CarType();
		carType.setCode("S7");
		
		int res = dao.deleteCarType(carType);
		Assert.assertEquals(1, res);
	}

}

























