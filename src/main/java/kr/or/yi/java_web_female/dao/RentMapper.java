package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.or.yi.java_web_female.dto.Rent;

public interface RentMapper {
	
	@Select("select concat('R', lpad((round(substring(max(code), 2,3)) + 1), 3, '0')) from rent")
	String getNextRentNo();
	
	@Insert("insert into rent values (#{code}, #{startDate}, #{startTime}, #{endDate}, #{endTime}, #{isReturn}, #{totalPrice}, #{carCode.carCode}, #{customerCode.code}, #{insuranceCode.code}, #{eCode}, #{optPrice})")
	int insertRent(Rent rent);

	void deleteRent(Rent rent);
	
	//
	List<Rent> selectRentByAll();
}
