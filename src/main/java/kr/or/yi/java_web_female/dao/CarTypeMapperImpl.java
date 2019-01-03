package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CarTypeMapperImpl implements CarTypeMapper {
	private static final CarTypeMapperImpl instance = new CarTypeMapperImpl();
	
	public static CarTypeMapperImpl getInstance() {
		return instance;
	}

	private CarTypeMapperImpl() {}
	
	private static final String namespace = "kr.or.yi.java_web_female.dao.CarTypeMapper";
	
	
	@Override
	public CarType selectCarTypeByNo(CarType carType) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace+".selectCarTypeByNo", carType);
		}
	}

	@Override
	public List<CarType> selectCarTypeByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace+".selectCarTypeByAll");
		}
	}

	@Override
	public int insertCarType(CarType carType) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace+".insertCarType",carType);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateCarType(CarType carType) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace+".updateCarType",carType);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCarType(CarType carType) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace+".deleteCarType",carType);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public String nextTypeCode() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace+".nextTypeCode");
		}
	}

}
