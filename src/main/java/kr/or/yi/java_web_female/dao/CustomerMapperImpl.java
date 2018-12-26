package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class CustomerMapperImpl implements CustomerMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.CustomerMapper";

	// SingletonPattern
	private static final CustomerMapperImpl instance = new CustomerMapperImpl();

	// getter,setter
	public static CustomerMapperImpl getInstance() {
		return instance;
	}

	// default 생성자 만들기
	private CustomerMapperImpl() {
	}

	@Override
	public List<Customer> selectCustomerByName(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectCustomerByName", customer);
		}
	}

	@Override
	public List<Customer> selectCustomerByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectCustomerByAll");
		}
	}

	@Override
	public Customer selectCustomerById(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectCustomerById", customer);
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
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".nextCustomerCode");
		}
	}

	@Override
	public String nextCode() {
		StringBuilder sb = new StringBuilder();
		ResultHandler<Integer> resultHandler = new ResultHandler<Integer>() {
			@Override
			public void handleResult(ResultContext<? extends Integer> resultContext) {
				sb.append(String.format("C%03d", resultContext.getResultObject()));
			}
		};

		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			sqlSession.select(namespace + ".nextCode", resultHandler);
			return sb.toString();
		}
	}

	@Override
	public Customer selectCustomerByPw(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectCustomerByPw", customer);
		}
	}

	
	// 추가
	@Override
	public List<Customer> selectCustomerByCode(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectCustomerByCode", customer);
		}
	}

	@Override
	public int updateCustomer(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateCustomer", customer);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCustomer(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteCustomer", customer);
			sqlSession.commit();
			return res;
		}
	}

///////////////////////// 트랜잭션 처리 //////////////////////////
	@Override
	public void insertCustomerJoin(Customer customer, CustomEvent customEvent) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.insert(namespace + ".insertCustomer", customer);
			sqlSession.insert("kr.or.yi.java_web_female.dao.CustomEventMapper.insertCustomEvent", customEvent);
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			System.err.println("sqlSession.rollback()");
			throw new RuntimeException(e.getCause());
		} finally {
			sqlSession.close();
		}
	}
///////////////////////// 트랜잭션 처리 //////////////////////////

	@Override
	public void deleteCustomerEvent(Customer customer, CustomEvent customEvent) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.delete("kr.or.yi.java_web_female.dao.CustomEventMapper.deleteCustomEvent", customEvent);
			sqlSession.delete(namespace + ".deleteCustomer", customer);
			sqlSession.commit();
		}catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			System.err.println("sqlSession.rollback()");
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int updateCustomerRentCnt(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".updateCustomerRentCnt", customer);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public String selectGradeCustomer(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectGradeCustomer", customer);
		}
	}

	@Override
	public int updateCustomerGrade(Customer customer) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".updateCustomerGrade", customer);
			sqlSession.commit();
			return res;
		}
	}


}
