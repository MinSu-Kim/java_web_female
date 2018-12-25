package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.yi.java_web_female.dto.CustomEvent;
import kr.or.yi.java_web_female.dto.Customer;

public interface CustomerMapper {
	List<Customer> selectCustomerByName(Customer customer);
	List<Customer> selectCustomerByAll();
	Customer selectCustomerById(Customer customer);

	int insertCustomer(Customer customer);
	int updateCustomer(Customer customer);
	int deleteCustomer(Customer customer);

	int nextCustomerCode();
	String nextCode();

	Customer selectCustomerByPw(Customer customer);
	// 추가
	List<Customer> selectCustomerByCode(Customer customer);
	
///////////////////////// 트랜잭션 처리 //////////////////////////
	void insertCustomerJoin(Customer customer, CustomEvent customEvent);
///////////////////////// 트랜잭션 처리 //////////////////////////
	void deleteCustomerEvent(Customer customer, CustomEvent customEvent);
	
	// rent 등록시 customer의 대여횟수 1증가
	@Update("update customer set rent_cnt = rent_cnt + 1 where code=#{code}")
	int updateCustomerRentCnt(Customer customer);
	// 대여횟수 1증가시 등급조정하기 위한 등급검색
	@Select("select g.code from customer c , grade g where (rent_cnt between g.g_losal and g.g_hisal) and c.code=#{code}")
	String selectGradeCustomer(Customer customer);
	// 등급 조정
	@Update("update customer set grade_code = #{gradeCode.code} where code = #{code}")
	int updateCustomerGrade(Customer customer);
}
