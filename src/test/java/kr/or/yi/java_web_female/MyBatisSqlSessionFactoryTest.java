package kr.or.yi.java_web_female;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest extends AbstractTest{
	
	@Test
	public void testOpenSession() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		log.debug("session "+session);
		Assert.assertNotNull(session);
	}

}
