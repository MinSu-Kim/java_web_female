package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Post;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class PostMapperImpl implements PostMapper {
   private static final String namespace = "kr.or.yi.java_web_female.dao.PostMapper";

   @Override
   public List<Post> selectPostByName( Post address) {
      try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
         return sqlSession.selectList(namespace + ".selectPostByName", address);
      }
   }



}