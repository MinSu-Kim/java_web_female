package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class RentMapperImpl implements RentMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.RentMapper";
	   
	private static final RentMapper instance = new RentMapperImpl();
	
	public static RentMapper getInstance() {
		return instance;
	}

	private RentMapperImpl() {}


	@Override
	public String getNextRentNo() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace+".getNextRentNo");
		}
	}

}
