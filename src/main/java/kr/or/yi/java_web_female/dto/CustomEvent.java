package kr.or.yi.java_web_female.dto;

import java.util.List;

public class CustomEvent {
	private String eventCode;
	private String customCode;
	private boolean isUse;
	private List<Event> events;

	public CustomEvent() {
	}
	
	

	public CustomEvent(String eventCode, String customCode, boolean isUse) {
		this.eventCode = eventCode;
		this.customCode = customCode;
		this.isUse = isUse;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		System.out.println("----------------------------------------------");
		System.out.println(events);
		System.out.println("----------------------------------------------");
		return String.format("%s", events);
	}

}
