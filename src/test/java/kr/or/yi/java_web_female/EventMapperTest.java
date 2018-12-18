package kr.or.yi.java_web_female;


import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.EventMapper;
import kr.or.yi.java_web_female.dao.EventMapperImpl;
import kr.or.yi.java_web_female.dto.Event;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventMapperTest extends AbstractTest{
	private EventMapper dao = EventMapperImpl.getInstance();

	@Test
	public void test01selectEventByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Event searchEvent = new Event();
		searchEvent.setCode("EVT1");

		Event searchedEvent = dao.selectEventByNo(searchEvent);
		Assert.assertNotNull(searchedEvent);
	}

	@Test
	public void test02selectEventByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Event> eventList = dao.selectEventByAll();
		Assert.assertNotNull(eventList);
	}

	@Test
	public void test03insertEvent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Event event = new Event();
		event.setCode("EVT3");
		event.setName("이달의 할인");
		event.setRate(7);
		int res = dao.insertEvent(event);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04updateEvent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Event event = new Event();
		event.setCode("EVT3");
		event.setName("특별한 할인");
		event.setRate(8);

		int res = dao.updateEvent(event);
		Assert.assertSame(1, res);

	}

	@Test
	public void test05deleteEvent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Event event = new Event();
		event.setCode("EVT3");
		int res = dao.deleteEvent(event);
		Assert.assertEquals(1, res);
	}

}
