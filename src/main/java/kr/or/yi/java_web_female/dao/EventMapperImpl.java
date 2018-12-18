package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Event;

public class EventMapperImpl implements EventMapper{
	private static final String namespace = "kr.or.yi.java_web_female.dao.EventMapper";
	private static final EventMapperImpl instance = new EventMapperImpl();
	
	public static EventMapperImpl getInstance() {
		return instance;
	}

	private EventMapperImpl() {
	}

	@Override
	public Event selectGradeByNo(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> selectGradeByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGrade(Event event) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGrade(Event event) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGrade(Event event) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
