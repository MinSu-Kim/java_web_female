package kr.or.yi.java_web_female.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.dto.Grade;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.RentHour;
import kr.or.yi.java_web_female.dto.StateCar;
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

	@Override
	public List<Rent> selectRentByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectRentByAll");
		}
	}

	@Override
	public RentHour selectRentHours(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectRentHours" ,map );
		}
	}

	@Override
	public int changeisReturn(Rent rent) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.update(namespace + ".changeisReturn", rent);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<Rent> FilterRentInfo(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".FilterRentInfo", map);
		}
	}

	@Override
	public List<Rent> selectRentAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectRentAll");
		}
	}

	@Override
	public List<StateCar> selectCountRentByMonth() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectCountRentByMonth");
		}
		
	}

	@Override
	public List<StateCar> selectCountRentByMonthWithCarType(String carType) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCountRentByMonthWithCarType", carType);
		}
	}

	@Override
	public List<StateCar> selectCountRentByMonthWithBrand(String brand) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectCountRentByMonthWithBrand", brand);
		}
	}

	@Override
	public List<StateCar> selectCarOptionsWithRentCode() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCarOptionsWithRentCode");
		}
	}

	@Override
	public List<Rent> selectRentAllByCustomerCode(String customerCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectRentAllByCustomerCode", customerCode);
		}
	}

	@Override
	public List<StateCar> selectPreference(String customerCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectPreference", customerCode);
		}
	}

	@Override
	public List<StateCar> selectCarTypeStat(String customerCode) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCarTypeStat", customerCode);
		}
	}

/*	@Override
	public List<StateCar> selectCarTypeCarNameStat(Map<String, String> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectCarTypeStat", map);
		}
	}*/

}
