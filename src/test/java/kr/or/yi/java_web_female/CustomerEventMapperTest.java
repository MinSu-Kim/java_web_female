package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.CustomEventMapper;
import kr.or.yi.java_web_female.dao.CustomEventMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerEventMapperTest extends AbstractTest {

	private CustomEventMapper dao = CustomEventMapperImpl.getInstance();

	@Test
	public void test01selectCustomEventByCustomCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<CustomEvent> customEvents = dao.selectCustomEventByCustomCode("C001");
		System.out.println(customEvents);
		System.out.println("size : " + customEvents.size());
		Assert.assertNotNull(customEvents);
	}

}
