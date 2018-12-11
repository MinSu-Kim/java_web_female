package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CustomerMapperImpl implements CustomerMapper {
    private static final String namespace = "kr.or.yi.java_web_female.dao.CustomerMapper";                                                                               
	
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

}
