package kr.or.yi.java_web_female.dto;

public class Address {
	private String zipcode;
	private String sido;
	private String sigungu;
	private String doro;
	private int buliding1;
	private String buliding2;
	
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
	public String getBuliding2() {
		return buliding2;
	}
	public void setBuliding2(String buliding2) {
		this.buliding2 = buliding2;
	}
	
	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", sido=" + sido + ", sigungu=" + sigungu + ", doro=" + doro
				+ ", buliding1=" + buliding1 + ", buliding2=" + buliding2 + "]";
	}
	
	
}
