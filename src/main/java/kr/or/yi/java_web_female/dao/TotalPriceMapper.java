package kr.or.yi.java_web_female.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import kr.or.yi.java_web_female.dto.totalPrice;

public interface TotalPriceMapper {
	
	@Select("select * from vw_price_stat")
	List<totalPrice> selectTotalPrice();
}
