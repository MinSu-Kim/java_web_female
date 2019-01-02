package kr.or.yi.java_web_female.dto;

public class RentHour {
	private int hour6;
	private int hour10;
	private int hour12;
	private int hourElse;
	private int overHour;
	private int basicCharge;

	public int getBasicCharge() {
		return basicCharge;
	}

	public void setBasicCharge(int basicCharge) {
		this.basicCharge = basicCharge;
	}

	public int getHour6() {
		return hour6;
	}

	public void setHour6(int hour6) {
		this.hour6 = hour6;
	}

	public int getHour10() {
		return hour10;
	}

	public void setHour10(int hour10) {
		this.hour10 = hour10;
	}

	public int getHour12() {
		return hour12;
	}

	public void setHour12(int hour12) {
		this.hour12 = hour12;
	}

	public int getHourElse() {
		return hourElse;
	}

	public void setHourElse(int hourElse) {
		this.hourElse = hourElse;
	}

	public int getOverHour() {
		return overHour;
	}

	public void setOverHour(int overHour) {
		this.overHour = overHour;
	}

	@Override
	public String toString() {
		return "RentHour [hour6=" + hour6 + ", hour10=" + hour10 + ", hour12=" + hour12 + ", hourElse=" + hourElse
				+ ", overHour=" + overHour + ", basicCharge=" + basicCharge + "]";
	}

	public int getAddPrice() {
		if(overHour <= 24) {
			return getAddHourPrice();
		} else {
			int day = overHour / 24;
			overHour = overHour % 24;
			return day * basicCharge + getAddHourPrice();
		}
	}

	private int getAddHourPrice() {
		if (overHour < 6) {
			return hour6;
		} else if (overHour < 10) {
			return hour10;
		} else if (overHour <= 12) {
			return hour12;
		} else {
			return hourElse;
		}
	}
}
