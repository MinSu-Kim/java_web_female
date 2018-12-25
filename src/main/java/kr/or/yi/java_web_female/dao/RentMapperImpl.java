package kr.or.yi.java_web_female.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class RentMapperImpl implements RentMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.RentMapper";
	   
	private static final RentMapper instance = new RentMapperImpl();
	
	public static RentMapper getInstance() {
		return instance;
	}

	private RentMapperImpl() {}


	@Override
	public String getNextRentNo() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace+".getNextRentNo");
		}
	}

	@Override
	public int insertRent(Rent rent) {
		int res = 0;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			String custom_namespace = "kr.or.yi.java_web_female.dao.CustomerMapper";
			Customer customer = rent.getCustomerCode();
			sqlSession.update(custom_namespace + ".updateCustomerRentCnt", customer);
			String gradeCode = sqlSession.selectOne(custom_namespace+".selectGradeCustomer", customer);
			customer.setGradeCode(new Grade(gradeCode));
			sqlSession.update(custom_namespace + ".updateCustomerGrade",  customer);
			
			sqlSession.update("kr.or.yi.java_web_female.dao.CarModelMapper.updateCarModelRent", rent.getCarCode());
			
			sqlSession.update("kr.or.yi.java_web_female.dao.CustomEventMapper.updateSetUse", rent);
			
			res = sqlSession.insert(namespace + ".insertRent", rent);
			
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			System.err.println("sqlSession.rollback()");
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
		return res;
	}

	@Override
	public void deleteRent(Rent rent) {
		// TODO Auto-generated method stub
		
	}

}
