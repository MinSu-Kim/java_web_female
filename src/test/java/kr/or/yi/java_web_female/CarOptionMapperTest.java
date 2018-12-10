package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.CarOptionMapper;
import kr.or.yi.java_web_female.dao.CarOptionMapperImpl;
import kr.or.yi.java_web_female.dto.CarOption;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarOptionMapperTest extends AbstractTest {
	private CarOptionMapper dao = new CarOptionMapperImpl();
	
	@Test
	public void test01selectCarOptionByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarOption searchCarOption = new CarOption();
		searchCarOption.setNo(1);
		
		CarOption newCarOption = dao.selectCarOptionByNo(searchCarOption);
		Assert.assertNotNull(newCarOption);
	}
	
	@Test
	public void test02selectCarOptionByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<CarOption> list = dao.selectCarOptionByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03insertCarOption() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarOption carOption = new CarOption();
		carOption.setNo(5);
		carOption.setName("네비게이션");
		carOption.setPrice(5000);
		
		int res = dao.insertCarOption(carOption);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04updateCarOption() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarOption carOption = new CarOption();
		carOption.setNo(5);
		carOption.setName("블랙박스");
		carOption.setPrice(7000);
		
		int res = dao.updateCarOption(carOption);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05deleteCarOption() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarOption carOption = new CarOption();
		carOption.setNo(5);
		int res = dao.deleteCarOption(carOption);
		Assert.assertEquals(1, res);
	}
}





















