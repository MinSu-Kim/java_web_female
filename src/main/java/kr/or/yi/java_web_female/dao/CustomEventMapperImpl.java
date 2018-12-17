package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CustomEventMapperImpl implements CustomEventMapper {
	
private static final String namespace = "kr.or.yi.java_web_female.dao.CustomEventMapper";

	private static final CustomEventMapperImpl instance = new CustomEventMapperImpl();
	
	public static CustomEventMapperImpl getInstance() {
		return instance;
	}

	@Override
	public int insertCustomEvent(CustomEvent customEvent) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertCustomEvent", customEvent);
			sqlSession.commit();
			return res;
		}
	}

}
