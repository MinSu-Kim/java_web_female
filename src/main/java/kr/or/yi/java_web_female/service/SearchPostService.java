package kr.or.yi.java_web_female.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.yi.java_web_female.dao.PostMapper;
import kr.or.yi.java_web_female.dao.PostMapperImpl;
import kr.or.yi.java_web_female.dto.Post;

public class SearchPostService {
   private PostMapper dao;

   public SearchPostService() {
      super();
      dao =  PostMapperImpl.getInstance();
   }
   
   public List<Post> selectPostByName(Post doro) throws SQLException{
      return dao.selectPostByName(doro);
   }

}