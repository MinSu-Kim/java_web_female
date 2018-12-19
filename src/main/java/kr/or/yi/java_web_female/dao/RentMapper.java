package kr.or.yi.java_web_female.dao;

import org.apache.ibatis.annotations.Select;

public interface RentMapper {
	
	@Select("select concat('R', LPAD(count(*)+1,3,'0')) from rent")
	String getNextRentNo();

}
