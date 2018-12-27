package kr.or.yi.java_web_female.dto;

public class StateCar {
	
	private String title;
	private int count;

	private StateCar() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	@Override
	public String toString() {
		return String.format("StateCarDto [title=%s, count=%s]", title, count);
	}
	
	
}
