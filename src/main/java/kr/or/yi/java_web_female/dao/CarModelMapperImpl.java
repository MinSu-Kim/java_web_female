package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CarModelMapperImpl implements CarModelMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.CarModelMapper";

	@Override
	public CarModel selectCarModelByNo(CarModel carModel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace+".selectCarModelByNo",carModel);
		}
	}

	@Override
	public List<CarModel> selectCarModelByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectCarModelByAll");
		}
	}

	@Override
	public int insertCarModel(CarModel carModel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace+".insertCarModel",carModel);
			sqlSession.commit();
			return res;		
		}
		
	}

	@Override
	public int updateCarModel(CarModel carModel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace+".updateCarModel",carModel);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCarModel(CarModel carModel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace+".deleteCarModel",carModel);
			sqlSession.commit();
			return res;
		}
		
	}

	@Override
	public List<CarModel> selectCarModelWithCarOptionByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectCarModelWithCarOptionByAll");
		}
		
	}

	@Override
	public List<CarModel> selectCarModelWithCarOptionByCode(CarModel carModel) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectCarModelWithCarOptionByCode",carModel);
		}
	}

}















