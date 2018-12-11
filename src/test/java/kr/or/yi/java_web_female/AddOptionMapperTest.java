package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.yi.java_web_female.dao.AddOptionMapper;
import kr.or.yi.java_web_female.dao.AddOptionMapperImpl;
import kr.or.yi.java_web_female.dto.AddOption;
import kr.or.yi.java_web_female.dto.CarModel;

public class AddOptionMapperTest extends AbstractTest{
	private AddOptionMapper dao = new AddOptionMapperImpl();
	
	/*@Test
	public void test01selectAddOptionByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		AddOption searchOption = new AddOption();
		searchOption.setCarCode(new CarModel());
	}*/

}
