package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CarOptionMapperImpl implements CarOptionMapper {
	private static final CarOptionMapperImpl instance = new CarOptionMapperImpl();

	public static CarOptionMapperImpl getInstance() {
		return instance;
	}

	private CarOptionMapperImpl() {
		// TODO Auto-generated constructor stub
	}

	private static final String namespace = "kr.or.yi.java_web_female.dao.CarOptionMapper";

	@Override
	public CarOption selectCarOptionByNo(CarOption carOption) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectCarOptionByNo", carOption);
		}
	}

	@Override
	public List<CarOption> selectCarOptionByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectCarOptionByAll");
		}

	}

	@Override
	public int insertCarOption(CarOption carOption) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertCarOption", carOption);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateCarOption(CarOption carOption) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateCarOption", carOption);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCarOption(CarOption carOption) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteCarOption", carOption);
			sqlSession.commit();
			return res;
		}

	}

}
