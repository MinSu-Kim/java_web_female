package kr.or.yi.java_web_female.dto;

public class Brand {
	private int no; //브랜드코드
	private String name; //브랜드이름
	
	//get, set
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Brand [no=" + no + ", name=" + name + "]";
	}

}
