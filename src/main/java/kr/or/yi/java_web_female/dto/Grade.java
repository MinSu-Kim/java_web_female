package kr.or.yi.java_web_female.dto;

public class Grade {
	private String code; // 등급 코드
	private String name; // 등급명
	private int gLosal; // 등급 최소 범위
	private int gHisal; // 등급 최대범위
	private int rate; // 등급별 할인율



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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Grade(String code, String name, int gLosal, int gHisal, int rate) {
		super();
		this.code = code;
		this.name = name;
		this.gLosal = gLosal;
		this.gHisal = gHisal;
		this.rate = rate;
	}

	public Grade(String code) {
		super();
		this.code = code;
	}

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(String code, String name, int rate) {
		super();
		this.code = code;
		this.name = name;
		this.rate = rate;
	}
	

	@Override
	public String toString() {
		return String.format("%s", name);
//		return String.format("%s, %s", name, rate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
