package kr.or.yi.java_web_female.dto;

public class Title {
	private String code; //직책코드
	private String name; //직책명
	private boolean tGrant; //권한
	
	
	
	
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Title(String code, String name, boolean tGrant) {
		super();
		this.code = code;
		this.name = name;
		this.tGrant = tGrant;
	}


	/*getter & setter*/
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean istGrant() {
		return tGrant;
	}
	public void settGrant(boolean tGrant) {
		this.tGrant = tGrant;
	}
	
	@Override
	public String toString() {
		return "Title [code=" + code + ", name=" + name + ", tGrant=" + tGrant + "]";
	}
	
	
	
	
	
	
}
