package kr.or.yi.java_web_female;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.UserPicMapper;
import kr.or.yi.java_web_female.dao.UserPicMapperImpl;
import kr.or.yi.java_web_female.dto.UserPic;
import kr.or.yi.java_web_female.jdbc.C3P0DataSourceFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private UserPicMapper dao = UserPicMapperImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//미리 이미지 외래키 무시하고 추가하기
		String[] arr = {"V000","V001","V002","V003","V004","V005","V006","V007","V008","V009","V010","V011","V012"};
		
		C3P0DataSourceFactory cds = new C3P0DataSourceFactory();
		Properties properties = new Properties();
		properties.put("password", "rootroot");
		properties.put("url", "jdbc:mysql://localhost/proj_rentcar?useSSL=false");
		properties.put("username", "root");
		properties.put("driver", "com.mysql.jdbc.Driver");
		cds.setProperties(properties);
		DataSource ds = cds.getDataSource();
		
		String delSql = "delete from userpic";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(delSql);){
			pstmt.executeUpdate();
		}
		
		String sql = "INSERT INTO userpic(car_code, pic) VALUES(?, ?)";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.addBatch("SET FOREIGN_KEY_CHECKS = 0");

			for(String name : arr) {
				pstmt.setString(1, name);
				pstmt.setBytes(2, getPicFile(name));
				pstmt.addBatch();
			}
			
			pstmt.addBatch("SET FOREIGN_KEY_CHECKS = 1");
			int[] res = pstmt.executeBatch();
			System.out.println(Arrays.toString(res));
		}
	}
	
	@Test
	public void test01insertUserPic() throws IOException, SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		//외래키 문제에 따른 해결
		UserPic userpic = new UserPic();
		userpic.setCarCode("V013");
		userpic.setPic(getPicFile("V013"));
		
		int res = dao.insertUserPic(userpic);
		Assert.assertEquals(1, res);
	}

	private static byte[] getPicFile(String fileName) throws IOException {
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
		File pics = new File(System.getProperty("user.dir")+"/images/");
		if(!pics.exists()) {
			pics.mkdirs();
		}
		File file = new File(pics, userPic.getCarCode()+".png");
		try(FileOutputStream output = new FileOutputStream(file)){
			output.write(userPic.getPic());
		}
		return file;
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		File pics = new File(System.getProperty("user.dir")+"/images/");
		if(pics.exists()) {
			for(File f : pics.listFiles()) {
				f.delete();
			}
			pics.delete();
		}
	}
}

















