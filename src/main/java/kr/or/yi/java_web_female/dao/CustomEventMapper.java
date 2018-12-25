package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.CustomEvent;

public interface CustomEventMapper {
	int insertCustomEvent(CustomEvent customEvent);
	
	List<CustomEvent> selectCustomEventByCustomCode(String customCode);
	
	int deleteCustomEvent(CustomEvent customEvent);
	
}
