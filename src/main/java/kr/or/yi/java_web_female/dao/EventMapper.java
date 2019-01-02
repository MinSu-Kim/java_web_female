package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Event;



public interface EventMapper {
	Event selectEventByNo(Event event);
	List<Event> selectEventByAll();
	int insertEvent(Event event);
	int updateEvent(Event event);
	int deleteEvent(Event event);
}
