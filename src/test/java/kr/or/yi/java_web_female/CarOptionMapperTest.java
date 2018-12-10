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
//		CarOption carOption = new Ca
	}

}





















