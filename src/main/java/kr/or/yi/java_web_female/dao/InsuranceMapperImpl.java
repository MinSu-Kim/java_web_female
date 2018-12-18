package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.Insurance;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class InsuranceMapperImpl implements InsuranceMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.InsuranceMapper";
	private static final InsuranceMapperImpl instance = new InsuranceMapperImpl();
	
	public static InsuranceMapper getInstance() {
		return instance;
	}
	
	@Override
	public List<Insurance> selectInsuranceByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectInsuranceByAll");
		}
	}

	@Override
	public int insertInsurance(Insurance insurance) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertInsurance", insurance);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public int updateInsurance(Insurance insurance) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace + ".updateInsurance", insurance);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public int deleteInsurance(Insurance insurance) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.delete(namespace + ".deleteInsurance", insurance);
			sqlSession.commit();
			
			return res;
		}
	}

	@Override
	public Insurance selectInsuranceByCode(Insurance insurance) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".selectInsuranceByCode", insurance);
		}
	}
}
