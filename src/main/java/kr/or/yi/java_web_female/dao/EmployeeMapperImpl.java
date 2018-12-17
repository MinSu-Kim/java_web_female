package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.java_web_female.dto.Employee;
import kr.or.yi.java_web_female.jdbc.MyBatisSqlSessionFactory;

public class EmployeeMapperImpl implements EmployeeMapper {
	private static final String namespace = "kr.or.yi.java_web_female.dao.EmployeeMapper";
	private static final EmployeeMapperImpl instance = new EmployeeMapperImpl();

	public static EmployeeMapperImpl getInstance() {
		return instance;
	}

	private EmployeeMapperImpl() {
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectEmployeeByNo", employee);
		}
	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectEmployeeByAll");
		}
	}

	@Override
	public int insertEmployee(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertEmployee", employee);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteEmployee(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteEmployee", employee);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int selectEmployeeById(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			Employee selectedEmployee = sqlSession.selectOne(namespace + ".selectEmployeeById", employee);
			if (selectedEmployee == null) {
				return 0;
			}
			return 1;
		}
	}

	public Employee selectEmployeeByPw(Employee employee) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectEmployeeByPw", employee);
		}
	}
}
