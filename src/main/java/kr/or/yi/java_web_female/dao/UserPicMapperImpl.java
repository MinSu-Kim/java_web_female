package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.UserPic;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private static final UserPicMapperImpl instance = new UserPicMapperImpl();
	
	public static UserPicMapperImpl getInstance() {
		return instance;
	}
	private UserPicMapperImpl() {};
	
	private static final String namespace = "kr.or.yi.java_web_female.dao.UserPicMapper";
	
	@Override
	public int insertUserPic(UserPic userPic) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace+".insertUserPic",userPic);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public UserPic getUserPic(String carCode) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace+".getUserPic",carCode);
		}
	}
	@Override
	public int deleteUserPic(UserPic userPic) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace+".deleteUserPic",userPic);
			sqlSession.commit();
			return res;
		}
	}

}
