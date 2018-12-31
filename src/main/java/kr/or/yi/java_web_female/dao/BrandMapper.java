package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.StateCar;

public interface BrandMapper {
	
	Brand selectBrandByNo(Brand brand);
	List<Brand> selectBrandByAll();
	int insertBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Brand brand);
	
	@Select("select brand, count(*)as count from rent r join car_model m on r.car_code = m.car_code group by m.brand")
	List<StateCar> selectCountByBrand();
}
