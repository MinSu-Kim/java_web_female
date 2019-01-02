package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.totalPrice;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class TotalPriceMapperImpl implements totalPriceMapper {
	private static final TotalPriceMapperImpl instance = new TotalPriceMapperImpl();
	
	public static TotalPriceMapperImpl getInstance() {
		return instance;
	}

	private static final String namespace = "kr.or.yi.java_web_female.dao.totalPriceMapper";
	
	@Override
	public List<totalPrice> selectTotalPrice() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectTotalPrice");
		}
	}

}