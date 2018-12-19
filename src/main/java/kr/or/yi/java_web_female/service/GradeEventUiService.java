package kr.or.yi.java_web_female.service;

import java.util.List;

import kr.or.yi.java_web_female.dao.EventMapper;
import kr.or.yi.java_web_female.dao.EventMapperImpl;
import kr.or.yi.java_web_female.dao.GradeMapper;
import kr.or.yi.java_web_female.dao.GradeMapperImpl;
import kr.or.yi.java_web_female.dto.Event;
import kr.or.yi.java_web_female.dto.Grade;

public class GradeEventUiService {
	private GradeMapper gradeDao;
	private EventMapper eventDao;
	
	
	public GradeEventUiService() {
		gradeDao = GradeMapperImpl.getInstance();
		eventDao = EventMapperImpl.getInstance();
	}
	
	//grade
	public List<Grade> selectGradeByAll(){
		return gradeDao.selectGradeByAll();
	}
	public int insertGrade(Grade grade){
		return gradeDao.insertGrade(grade);
	}
	public int updateGrade(Grade grade){
		return gradeDao.updateGrade(grade);
	}
	public int deleteGrade(Grade grade){
		return gradeDao.deleteGrade(grade);
	}
	
	//event
	public List<Event> selectEventByAll(){
		return eventDao.selectEventByAll();
	}
	public int insertEvent(Event event){
		return eventDao.insertEvent(event);
	}
	public int updateEvent(Event event){
		return eventDao.updateEvent(event);
	}
	public int deleteEvent(Event event){
		return eventDao.deleteEvent(event);
	}
}
