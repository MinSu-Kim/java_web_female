package kr.or.yi.java_web_female.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Rent;
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

	@Override
	public int insertRent(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertRent", rent);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public void procedureRent(Map<String, Object> map) {
		
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			sqlSession.selectOne(namespace + ".procedureRent", map);
		}
	}

	@Override
	public int procedureRent2(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.insert(namespace + ".procedureRent2", map);
		}
	}

	@Override
	public void insertRent(Rent rent, Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			sqlSession.insert(namespace + ".insertRent", rent);
			sqlSession.insert(namespace + ".procedureRent2", map);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			System.err.println("sqlSession.rollback()");
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public void deleteRent(Rent rent) {
		// TODO Auto-generated method stub
		
	}

}
