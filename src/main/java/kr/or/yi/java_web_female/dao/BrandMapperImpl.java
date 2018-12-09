package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class BrandMapperImpl implements BrandMapper {
	private String namespace = "kr.or.yi.java_web_female.dao.BrandMapper";

	@Override
	public Brand selectBrandByNo(Brand brand) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectBrandByNo", brand);
		}
	}

	@Override
	public List<Brand> selectBrandByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectBrandByAll");
		}
	}
	
	

}
