package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Grade;

public interface GradeMapper {
	Grade selectGradeByNo(Grade grade);
	List<Grade> selectGradeByAll();
	int insertGrade(Grade grade);
	int updateGrade(Grade grade);
	int deleteGrade(Grade grade);
	
	
}
