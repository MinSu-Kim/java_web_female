package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class GradeMapperImpl implements GradeMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.GradeMapper";
	private static final GradeMapperImpl instance = new GradeMapperImpl();
	
	
	
	public static GradeMapperImpl getInstance() {
		return instance;
	}


	private GradeMapperImpl() {}

	@Override
	public Grade selectGradeByNo(Grade grade) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectGradeByNo", grade);
		}
	}

}
