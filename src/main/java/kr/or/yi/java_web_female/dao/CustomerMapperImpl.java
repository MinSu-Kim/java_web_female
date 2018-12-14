package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CustomerMapperImpl implements CustomerMapper {
    private static final String namespace = "kr.or.yi.java_web_female.dao.CustomerMapper";    
   
	//SingletonPattern
	private static final CustomerMapperImpl instance = new CustomerMapperImpl();
	
	//getter,setter
	public static CustomerMapperImpl getInstance() {
		return instance;
	}
	
	//default 생성자 만들기
	private CustomerMapperImpl() {}
	
	@Override
	public List<Customer> selectCustomerByName(Customer customer) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectCustomerByName", customer);
		}
	}

	@Override
	public List<Customer> selectCustomerByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectList(namespace + ".selectCustomerByAll");
		}
	}

	@Override
	public int selectCustomerById(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			Customer selectedCustomer = sqlSession.selectOne(namespace + ".selectCustomerById", customer);
			if (selectedCustomer ==null) {
				return 0;
			}
			return 1;
		}
	}

	@Override
	public int insertCustomer(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertCustomer", customer);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int nextCustomerCode() {
		
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			return sqlSession.selectOne(namespace + ".nextCustomerCode");
		}
	}

}
