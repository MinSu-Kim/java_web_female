package kr.or.yi.java_web_female.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.or.yi.java_web_female.dto.Rent;

public interface RentMapper {
	
	@Select("select concat('R', LPAD(count(*)+1,3,'0')) from rent")
	String getNextRentNo();
	
	@Insert("insert into rent values (#{code}, #{startDate}, #{startTime}, #{endDate}, #{endTime}, #{isReturn}, #{totalPrice}, #{carCode.carCode}, #{customerCode.code}, #{insuranceCode.code}, #{eRate}, #{optPrice})")
	int insertRent(Rent rent);
	
//	@Select("{call update_customer_grade(#{custom_code, mode=IN, jdbcType=CHAR}, #{rent_code, mode=IN, jdbcType=CHAR}, #{carCode, mode=IN, jdbcType=CHAR})}")
//	@Options(statementType = StatementType.CALLABLE)
	
	void procedureRent(Map<String, String> map);

	
}
