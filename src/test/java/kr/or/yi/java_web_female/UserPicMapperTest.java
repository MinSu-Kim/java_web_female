package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import kr.or.yi.java_web_female.dao.UserPicMapper;
import kr.or.yi.java_web_female.dao.UserPicMapperImpl;
import kr.or.yi.java_web_female.dto.UserPic;

public class UserPicMapperTest extends AbstractTest {
	private UserPicMapper dao = UserPicMapperImpl.getInstance();
	
	@Test
	public void test01insertUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userpic = new UserPic();
		userpic.setCarCode("V001");
		userpic.setPic(getPicFile());
	}

	private byte[] getPicFile() {
		File pics = new File(System.getProperty("user.dir")+"\\images\\");//images파일안에 차종별로 나눠넣기
		if(!pics.exists()) {
			
		}
		return null;
	}

}

















