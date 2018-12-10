package kr.or.yi.java_web_female.dto;

public class Level {
	private String grade;
	private int gLosal;
	private int gHisal;

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getgLosal() {
		return gLosal;
	}
	public void setgLosal(int gLosal) {
		this.gLosal = gLosal;
	}
	public int getgHisal() {
		return gHisal;
	}
	public void setgHisal(int gHisal) {
		this.gHisal = gHisal;
	}
	
	@Override
	public String toString() {
		return "Level [grade=" + grade + ", gLosal=" + gLosal + ", gHisal=" + gHisal + "]";
	}
	
	
}
