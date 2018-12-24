package kr.or.yi.java_web_female.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import kr.or.yi.java_web_female.dto.Rent;

public interface RentMapper {
	
	@Select("select concat('R', lpad((round(substring(max(code), 2,3)) + 1), 3, '0')) from rent")
	String getNextRentNo();
	
	@Insert("insert into rent values (#{code}, #{startDate}, #{startTime}, #{endDate}, #{endTime}, #{isReturn}, #{totalPrice}, #{carCode.carCode}, #{customerCode.code}, #{insuranceCode.code}, #{eRate}, #{optPrice})")
	int insertRent(Rent rent);
	

	//Annotation에서 프로시저 호출은 @Insert로 해야 됨.
	@Insert("{call update_customer_grade(#{custom_code, mode=IN, jdbcType=CHAR}, #{rent_code, mode=IN, jdbcType=CHAR}, #{carCode, mode=IN, jdbcType=CHAR}, #{isGrade, mode = IN, jdbcType=INTEGER})}")
	@Options(statementType = StatementType.CALLABLE)
	int procedureRent2(Map<String, Object> map);
	
//	void procedureRent(Map<String, String> map);
	void procedureRent(Map<String, Object> map);  // isGrade의 값이 정수이므로 문자와 숫자를 저장해야하기때문에 
	
	///////////////
	void insertRent(Rent rent, Map<String, Object> map);
	void deleteRent(Rent rent);
	
}
