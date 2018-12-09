package kr.or.yi.java_web_female.dao;

import java.util.List;

import kr.or.yi.java_web_female.dto.Brand;

public interface BrandMapper {
	
	Brand selectBrandByNo(Brand brand);
	List<Brand> selectBrandByAll();
	int insertBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Brand brand);
}
