package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.AddOption;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class AddOptionMapperImpl implements AddOptionMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.AddOptionMapper";

	@Override
	public AddOption selectAddOptionByCarCode(AddOption addOption) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace+".selectAddOptionByNo",addOption);
		}
		
	}

	@Override
	public List<AddOption> selectAddOptionByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace+".selectAddOptionByAll");
		}
		
	}
	
	


}
