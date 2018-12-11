package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.AddOption;

public interface AddOptionMapper {
	AddOption selectAddOptionByCarCode(AddOption addOption);
	List<AddOption> selectAddOptionByAll();
}
