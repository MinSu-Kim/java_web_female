package kr.or.yi.java_web_female.ui.rent.sub;

public class RentDateDto {
	private String startDate;
	private String startHour;
	private String endDate;
	private String endHour;
	private long diff;
	
	
	public RentDateDto() {
		// TODO Auto-generated constructor stub
	}


	public RentDateDto(String startDate, String startHour, String endDate, String endHour, long diff) {
		this.startDate = startDate;
		this.startHour = startHour;
		this.endDate = endDate;
		this.endHour = endHour;
		this.diff = diff;
	}
	
	
	public long getDiff() {
		return diff;
	}

	public void setDiff(long diff) {
		this.diff = diff;
	}
	
	

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}


	@Override
	public String toString() {
		return String.format("RentDateDto [startDate=%s, startHour=%s, endDate=%s, endHour=%s, diff=%s]", startDate,
				startHour, endDate, endHour, diff);
	}
	
	
	
}
