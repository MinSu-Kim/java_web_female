package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Rent;
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

	@Override
	public List<CustomEvent> selectCustomEventByCustomCode(String customCode) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectCustomEventByCustomCode", customCode);
		}
	}

	@Override
	public int deleteCustomEvent(CustomEvent customEvent) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteCustomEvent", customEvent);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateSetUse(Rent rent) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateSetUse", rent);
			sqlSession.commit();
			return res;
		}
	}
}
