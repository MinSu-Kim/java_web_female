package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class BrandMapperImpl implements BrandMapper {
	private static final BrandMapperImpl instance = new BrandMapperImpl();//자기자신 생성
	//get,set
	public static BrandMapperImpl getInstance() {
		return instance;
	}
	
	private BrandMapperImpl() {}

	private static final String namespace = "kr.or.yi.java_web_female.dao.BrandMapper";

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

	@Override
	public int insertBrand(Brand brand) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace+".insertBrand",brand);
			sqlSession.commit();
			return res;
		}
		
	}

	@Override
	public int updateBrand(Brand brand) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace+".updateBrand", brand);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteBrand(Brand brand) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace+".deleteBrand", brand);
			sqlSession.commit();
			return res;
		}
	}
	
}












