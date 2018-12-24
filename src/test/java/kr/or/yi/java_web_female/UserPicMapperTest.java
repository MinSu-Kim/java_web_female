package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.UserPicMapper;
import kr.or.yi.java_web_female.dao.UserPicMapperImpl;
import kr.or.yi.java_web_female.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private UserPicMapper dao = UserPicMapperImpl.getInstance();
	
	@Test
	public void test01insertUserPic() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String[] arr = {"V001","V002","V003","V004","V005","V006","V007","V008","V009","V010","V011","V012","V013"};
		for(String name : arr) {
			UserPic userpic = new UserPic();
			userpic.setCarCode(name);
			userpic.setPic(getPicFile(name));
			int res = dao.insertUserPic(userpic);
			Assert.assertEquals(1, res);
		}

		
	}

	private byte[] getPicFile(String fileName) throws IOException {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir")+"/images/"+fileName+".png");
		try(InputStream is = new FileInputStream(file)){
			pic = new byte[is.available()];
			is.read(pic);
		}
		return pic;
	}
	
	@Test
	public void test02getUserPic() throws IOException {
		UserPic userPic = dao.getUserPic("V002");
		if(userPic.getPic()!=null) {
			File file = getPicFile(userPic);
			System.out.println("file path"+file.getAbsolutePath());
		}
		Assert.assertNotNull(userPic);
	}

	private File getPicFile(UserPic userPic) throws IOException {
		File pics = new File(System.getProperty("user.dir")+"/images/test/");
		if(!pics.exists()) {
			pics.mkdirs();
		}
		File file = new File(pics, userPic.getCarCode()+".png");
		try(FileOutputStream output = new FileOutputStream(file)){
			output.write(userPic.getPic());
		}
		return file;
	}

}

















