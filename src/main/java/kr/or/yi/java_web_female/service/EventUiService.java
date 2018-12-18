package kr.or.yi.java_web_female.service;

import kr.or.yi.java_web_female.dao.EventMapper;
import kr.or.yi.java_web_female.dao.EventMapperImpl;

public class EventUiService {
	private EventMapper eventDao;
	
	public EventUiService() {
		eventDao = EventMapperImpl.getInstance();
	}
}
