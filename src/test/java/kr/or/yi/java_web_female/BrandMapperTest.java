package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_female.dao.BrandMapper;
import kr.or.yi.java_web_female.dao.BrandMapperImpl;
import kr.or.yi.java_web_female.dto.Brand;

public class BrandMapperTest extends AbstractTest {
	private BrandMapper dao = new BrandMapperImpl();
	
	@Test
	public void test01selectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Brand searchBrand = new Brand();
		searchBrand.setNo("B1");
		
		Brand newBrand = dao.selectBrandByNo(searchBrand);
		Assert.assertNotNull(newBrand);
	}
	
	@Test
	public void test02selectBrandByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Brand> list = dao.selectBrandByAll();
		Assert.assertNotNull(list);
		
	}

}
