package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Post;

public interface PostMapper {
	List<Post> selectPostByName ();
	List<Post> selectPostByAll();
}
