package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Post;

public interface PostMapper {
	Post selectPostByNo (Post post);
//	List<Post> selectPostByAll();
}
