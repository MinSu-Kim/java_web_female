package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class PostMapperImpl implements PostMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.PostMapper";

	@Override
	public Post selectPostByNo(Post post) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectPostByNo", post);
		}
	}

}
