package kr.or.yi.java_web_female.dto;

public class Brand {
	private String no; //브랜드코드
	private String name; //브랜드이름
	
	
	
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(String no) {
		super();
		this.no = no;
	}
	//get, set
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
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
