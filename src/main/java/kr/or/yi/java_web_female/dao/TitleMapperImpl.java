package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Title;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class TitleMapperImpl implements TitleMapper{
	private static final String namespace = "kr.or.yi.java_web_female.dao.TitleMapper";
	
	@Override
	public Title selectTitleByNo(Title title) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectTitleByNo", title);
		}
	}

}
