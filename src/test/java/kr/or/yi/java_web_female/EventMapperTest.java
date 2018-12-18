package kr.or.yi.java_web_female;

import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_female.dao.CustomEventMapper;
import kr.or.yi.java_web_female.dao.CustomEventMapperImpl;
import kr.or.yi.java_web_female.dto.CustomEvent;


public class EventMapperTest extends AbstractTest{
	private CustomEventMapper dao = CustomEventMapperImpl.getInstance();

/*	@Test
	public void testinsertCustomEvent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CustomEvent customEvent = new CustomEvent(null, null, false);
		customEvent.setCustomCode("C001");
		customEvent.setEventCode("EVT2");
		customEvent.setUse(false);
		int res = dao.insertCustomEvent(customEvent);
		Assert.assertEquals(1, res);
	}*/

}
