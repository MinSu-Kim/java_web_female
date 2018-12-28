package kr.or.yi.java_web_female.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.RentHour;

public interface RentMapper {
	
	@Select("select concat('R', lpad((round(substring(max(code), 2,3)) + 1), 3, '0')) from rent")
	String getNextRentNo();
	
	@Insert("insert into rent values (#{code}, #{startDate}, #{startTime}, #{endDate}, #{endTime}, #{isReturn}, #{totalPrice}, #{carCode.carCode}, #{customerCode.code}, #{insuranceCode.code}, #{eCode}, #{optPrice})")
	int insertRent(Rent rent);

	void deleteRent(Rent rent);
	
	//
	List<Rent> selectRentByAll();
	
	List<Rent> selectRentAll();
	
	//초과 시간
	RentHour selectRentHours(Map<String, String> map);
	
	//반납 처리하기
	@Update("update rent set is_return = 1 where code = #{code}")
	int changeisReturn(Rent rent);
	
	//
	List<Rent> FilterRentInfo(Map<String, String> map);
}
