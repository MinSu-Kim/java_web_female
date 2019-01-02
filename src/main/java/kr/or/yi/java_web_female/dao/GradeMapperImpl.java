package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class GradeMapperImpl implements GradeMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.GradeMapper";
	private static final GradeMapperImpl instance = new GradeMapperImpl();

	public static GradeMapperImpl getInstance() {
		return instance;
	}

	private GradeMapperImpl() {
	}

	@Override
	public Grade selectGradeByNo(Grade grade) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectGradeByNo", grade);
		}
	}

	@Override
	public List<Grade> selectGradeByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectGradeByAll");
		}
	}

	@Override
	public int insertGrade(Grade grade) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertGrade", grade);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateGrade(Grade grade) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateGrade", grade);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteGrade(Grade grade) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteGrade", grade);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Grade selectGradeByName(Grade gradeName) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectGradeByName", gradeName);
		}
	}

	@Override
	public int chartGrade(Grade grade) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".chartGrade", grade);
		}
	}
}
