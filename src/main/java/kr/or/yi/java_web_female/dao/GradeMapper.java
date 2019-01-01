package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.or.yi.java_web_female.dto.Grade;

public interface GradeMapper {
	Grade selectGradeByNo(Grade grade);
	Grade selectGradeByName(Grade gradeName);
	List<Grade> selectGradeByAll();
	int insertGrade(Grade grade);
	int updateGrade(Grade grade);
	int deleteGrade(Grade grade);
	
	@Select("select g.name, count(g.name) from customer c left join grade g on c.grade_code = g.code where grade_code is not null group by grade_code")
	int chartGrade(Grade grade);
}
