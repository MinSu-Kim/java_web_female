package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.InsuranceMapper;
import kr.or.yi.java_web_female.dao.InsuranceMapperImpl;
import kr.or.yi.java_web_female.dto.Insurance;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InsuranceMapperTest extends AbstractTest {
	private InsuranceMapper dao = InsuranceMapperImpl.getInstance();

	@Test
	public void test01SelectInsuranceByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Insurance> list = dao.selectInsuranceByAll();
		Assert.assertNotNull(list);
	}

}
