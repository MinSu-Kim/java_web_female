package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Fuel;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class FuelMapperImpl implements FuelMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.FuelMapper";
	
	@Override
	public Fuel selectFuelByNo(Fuel fuel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace+".selectFuelByNo",fuel);
		}
		
	}

	@Override
	public List<Fuel> selectFuelByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectFuelByAll");
		}
	}

	@Override
	public int insertFuel(Fuel fuel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace+".insertFuel",fuel);
			sqlSession.commit();
			return res;
		}
		
	}

	@Override
	public int deleteFuel(Fuel fuel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace+".deleteFuel",fuel);
			sqlSession.commit();
			return res;
		}
		
	}

}
