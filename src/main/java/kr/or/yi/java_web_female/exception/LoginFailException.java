package kr.or.yi.java_web_female.exception;

@SuppressWarnings("serial")
public class LoginFailException extends Exception {

	public LoginFailException(String message) {
		super(message); //부모호출
	}

}
