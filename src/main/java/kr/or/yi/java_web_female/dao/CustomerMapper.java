package kr.or.yi.java_web_female.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
	
	@Delete("delete from customer where code=#{code}")
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
	
	/*@Select("select Id from customer c where c.phone = #{phone} and c.email = #{email}")*/
	Customer searchId(Customer customer);
	
	@Select("select concat( char(rand()*26 + 65) , round(rand() * 100), char(rand()*26 + 65), char(rand()*26 + 65) , round(rand() * 100), char(rand()*26 + 65)) as randomPwd")
	String getRandomPassword();
	
	@Update("update customer set passwd=password(#{passwd}) where phone = #{phone} and email = #{email}")
	int changePw(Customer customer);
	
	@Select("select passwd = password(#{passwd}) as samePwd from customer where Id = #{id}")
	int samePwd(Customer customer);
	

	
}
