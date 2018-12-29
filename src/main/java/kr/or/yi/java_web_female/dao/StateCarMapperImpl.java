package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.StateCar;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class StateCarMapperImpl implements StateCarMapper {
	private static final StateCarMapperImpl instance = new StateCarMapperImpl();
	
	public static StateCarMapperImpl getInstance() {
		return instance;
	}
	
	private static final String namespace = "kr.or.yi.java_web_female.dao.StateCarMapper";

	@Override
	public List<StateCar> selectCountByCarType() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectCountByCarType");
		}
	}

	@Override
	public List<StateCar> selectCountByBrand() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectCountByBrand");
		}
	}

}
