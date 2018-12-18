package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Event;



public interface EventMapper {
	Event selectGradeByNo(Event event);
	List<Event> selectGradeByAll();
	int insertGrade(Event event);
	int updateGrade(Event event);
	int deleteGrade(Event event);
}
