package kr.or.yi.java_web_female.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.RentHour;
import kr.or.yi.java_web_female.dto.StateCar;

public interface RentMapper {
	
	//월별 카운트 select
	@Select("SELECT DATE_FORMAT(start_date,'%Y-%m') as title, COUNT(*) as count FROM rent GROUP BY title")
	List<StateCar> selectCountRentByMonth();//2018-12로 출력 카운트는 숫자로 출력
	
	//브랜드별 카운트 select
	@Select("SELECT DATE_FORMAT(start_date,'%Y-%m') as title, b.name as brand, COUNT(*) as count FROM rent r join car_model cm on r.car_code = cm.car_code join brand b on cm.brand = b.no GROUP BY title, brand having b.name = #{brand}")
	List<StateCar> selectCountRentByMonthWithBrand(String brand);
	
	// 차트 1 ==========================================
	@Select("SELECT DATE_FORMAT(start_date,'%Y-%m') as title, ct.`type` as carType, COUNT(*) as count FROM rent r join car_model cm on r.car_code = cm.car_code join car_type ct on cm.cartype = ct.code GROUP BY title, carType having ct.`type` = #{carType}")
	List<StateCar> selectCountRentByMonthWithCarType(String carType);
	// ==========================================
	
	// 차트 2 ==========================================
	@Select("select co.name as title, count(*) as count from rent r join rentcar_options ro on r.code = ro.code join car_option co on ro.option_id = co.`no` group by name")
	List<StateCar> selectCarOptionsWithRentCode();
	// ==========================================
	
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
