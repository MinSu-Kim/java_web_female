package kr.or.yi.java_web_female;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.BrandMapper;
import kr.or.yi.java_web_female.dao.BrandMapperImpl;
import kr.or.yi.java_web_female.dto.Brand;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BrandMapperTest extends AbstractTest {
	private BrandMapper dao = new BrandMapperImpl();
	
	@Test
	public void test01selectBrandByNo() {
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
	
	@Test
	public void test03insertBrand() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Brand brand = new Brand();
		brand.setNo("B4");
		brand.setName("GM");
		
		int res = dao.insertBrand(brand);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04updateBrand() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Brand brand = new Brand();
		brand.setNo("B4");
		brand.setName("르노");
		
		int res = dao.updateBrand(brand);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test05deleteBrand() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Brand brand = new Brand();
		brand.setNo("B4");
		int res = dao.deleteBrand(brand);
		Assert.assertEquals(1, res);
	}
}
