package kr.or.yi.java_web_female;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.RentMapper;
import kr.or.yi.java_web_female.dao.RentMapperImpl;
import kr.or.yi.java_web_female.dto.Rent;
import kr.or.yi.java_web_female.dto.StateCar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentMapperTest extends AbstractTest {
	private RentMapper dao = RentMapperImpl.getInstance();
	
	@Test
	public void test01GetNextRentNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		String nextRentNo = dao.getNextRentNo();
		System.out.println(nextRentNo);
		Assert.assertNotNull(nextRentNo);
	}
	
	/*@Test
	public void test02InsertRent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		// Customer rent_cnt++
		// Customer grade_code G001, 횟수따른 등급 변경
		// Carmodel is_rent = 1, rent_cnt++
		// Custom_event is_use = 1
		// Rent 추가
		
		Rent rent = new Rent();
		rent.setCode(dao.getNextRentNo());
		rent.setStartDate("2018-12-23");
		rent.setStartTime("12:00:00");
		rent.setEndDate("2018-12-24");
		rent.setEndTime("12:00:00");
		rent.setReturn(false);
		rent.setTotalPrice(40000);
		rent.setCarCode(new CarModel("V004"));  // is_rent = 0, rent_cnt= 7
		Customer customer = new Customer();     // grade_code = G001, rent_cnt = 4
		customer.setCode("C006");
		rent.setCustomerCode(customer);        
		rent.setInsuranceCode(new Insurance("I000"));
		rent.seteCode("EVT1");                  // custom_event EVT1, C006 is_use = 0
//		rent.seteRate(5);
		rent.setOptPrice(5000);
		
		int res = dao.insertRent(rent);//R006 C006 V004 G1 5 c_event 5
		Assert.assertEquals(1, res);
		
	}*/
	

/*	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		C3P0DataSourceFactory cds = new C3P0DataSourceFactory();
		Properties properties = new Properties();
		properties.put("password", "rootroot");
		properties.put("url", "jdbc:mysql://localhost/proj_rentcar?useSSL=false");
		properties.put("username", "root");
		properties.put("driver", "com.mysql.jdbc.Driver");
		cds.setProperties(properties);
		DataSource ds = cds.getDataSource();
		
		String delSql = "delete from rent where code in ('R006', 'R007', 'R008')";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(delSql);){
			pstmt.executeUpdate();
		}
	}*/

	@Test
	public void test03SelectRentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Rent> list = dao.selectRentByAll();
		for(Rent r : list) {
			System.out.println(r);
		}
		Assert.assertNotNull(list);
	}
/*	
	@Test
	public void test04SelectRentHoursForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		CarModel cm = new CarModel();
		cm.setCarCode("V010");
		RentHour hour = dao.selectRentHours(cm);
		
		System.out.println(hour);
		
	}*/
	
	/*@Test
	public void test05changeisReturn() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Rent r = new Rent();
		r.setCode("R008");
		
		int res = dao.changeisReturn(r);
		Assert.assertEquals(1, res);
	}*/
	
	@Test
	public void test06FilterRentInfo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, String> map = new HashMap<>();
		map.put("isReturn", "기본값");
		map.put("carTypeCode", "소형");
		map.put("carTypeName", "아반떼AD");
		map.put("customerName", "김영희");
		
		System.out.println(map);
		map.remove("carTypeCode");
		System.out.println(map);
		/*List<Rent> list = dao.FilterRentInfo(map);
		Assert.assertNotNull(list);*/
	}
	
	@Test
	public void test07selectCountRentByMonth() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<StateCar> list = dao.selectCountRentByMonth();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test08selectCountRentByMonthWithBrand() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<StateCar> list = dao.selectCountRentByMonthWithBrand("kia");
		Assert.assertNotNull(list);
	}
}
