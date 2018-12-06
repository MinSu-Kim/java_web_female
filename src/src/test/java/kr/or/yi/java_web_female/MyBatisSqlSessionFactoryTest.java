package kr.or.yi.java_web_female;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest {
	
	private static final Log log = LogFactory.getLog(MyBatisSqlSessionFactoryTest.class);


	@Test
	public void testOpenSession() {
		log.debug("testOpenSession()");
		
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		log.debug("session "+session);
		Assert.assertNotNull(session);
	}

}
