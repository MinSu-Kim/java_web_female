package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Title;

public interface TitleMapper {
	Title selectTitleByNo(Title title);
	List<Title> selectTitleByAll();
	int insertTitle(Title title);
	int updateTitle(Title title);
	int deleteTitle(Title title);
}
