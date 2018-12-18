package kr.or.yi.java_web_female.dao;

import kr.or.yi.java_web_female.dto.UserPic;

public interface UserPicMapper {
	int insertUserPic(UserPic userPic);
	UserPic getUserPic(String carCode);
}
