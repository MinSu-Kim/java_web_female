package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CarOption;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CarOptionMapperImpl implements CarOptionMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.CarOptionMapper";
	
	@Override
	public CarOption selectCarOptionByNo(CarOption carOption) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace+".selectCarOptionByNo",carOption);
		}
	}

	@Override
	public List<CarOption> selectCarOptionByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectCarOptionByAll");
		}
		
	}

	@Override
	public int insertCarOption(CarOption carOption) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace+".insertCarOption",carOption);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateCarOption(CarOption carOption) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCarOption(CarOption carOption) {
		// TODO Auto-generated method stub
		return 0;
	}

}
