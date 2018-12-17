package kr.or.yi.java_web_female.dto;

public class CustomEvent {
	private String eventCode;
	private String customCode;
	private boolean isUse;

	public CustomEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomEvent(String eventCode, String customCode, boolean isUse) {
		super();
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
	
	@Override
	public String toString() {
		return "CustomEvent [eventCode=" + eventCode + ", customCode=" + customCode + ", isUse=" + isUse + "]";
	}

}
