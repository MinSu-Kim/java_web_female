package kr.or.yi.java_web_female.dto;

public class Post {
	private String zipcode;
	private String sido;
	private String sigungu;
	private String eupmyeon;
	private String doro;
	private int buliding1;
	private int buliding2;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String zipcode) {
		super();
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getEupmyeon() {
		return eupmyeon;
	}

	public void setEupmyeon(String eupmyeon) {
		this.eupmyeon = eupmyeon;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public int getBuliding1() {
		return buliding1;
	}

	public void setBuliding1(int buliding1) {
		this.buliding1 = buliding1;
	}

	public int getBuliding2() {
		return buliding2;
	}

	public void setBuliding2(int buliding2) {
		this.buliding2 = buliding2;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s", sido, sigungu, eupmyeon, doro, buliding1, buliding2);
	}

}