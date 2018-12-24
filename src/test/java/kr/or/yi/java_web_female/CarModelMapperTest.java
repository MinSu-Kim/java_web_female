package kr.or.yi.java_web_female;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.CarModelMapper;
import kr.or.yi.java_web_female.dao.CarModelMapperImpl;
import kr.or.yi.java_web_female.dto.Brand;
import kr.or.yi.java_web_female.dto.CarModel;
import kr.or.yi.java_web_female.dto.CarType;
import kr.or.yi.java_web_female.dto.Fuel;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarModelMapperTest extends AbstractTest {
	private CarModelMapper dao = CarModelMapperImpl.getInstance();
	
	@Test
	public void test01selectCarModelByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarModel searchModel = new CarModel();
		searchModel.setCarCode("V001");
		
		CarModel newModel = dao.selectCarModelByNo(searchModel);
		System.out.println(newModel);
		Assert.assertNotNull(newModel);
	}
	
	@Test
	public void test02selectCarModelByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<CarModel> list = dao.selectCarModelByAll();
		for(CarModel cm : list) {
			System.out.println(cm+":"+ cm.getCarType().getCode());
		}
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03insertCarModel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarModel carModel = new CarModel();
		carModel.setCarCode("V019");
		carModel.setName("벤츠");
		carModel.setColor("wh");
		carModel.setGear("auto");
		carModel.setBrand(new Brand("B4"));
		carModel.setCarType(new CarType("S2"));
		carModel.setBasicCharge(70000);
		carModel.setHour6(40000);
		carModel.setHour10(53000);
		carModel.setHour12(59000);
		carModel.setHourElse(70000);
		Fuel fuel = new Fuel();
		fuel.setCode("lpg");
		carModel.setFuel(fuel);
		carModel.setRent(false);
		carModel.setRentCnt(0);
		
		int res = dao.insertCarModel(carModel);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test01updateCarModel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarModel carModel = new CarModel();
		
		carModel.setCarCode("V019");
		carModel.setName("마티즈");
		carModel.setColor("bl");
		carModel.setGear("stick");
		carModel.setBrand(new Brand("B2"));
		carModel.setCarType(new CarType("S1"));
		carModel.setBasicCharge(60000);
		carModel.setHour6(30000);
		carModel.setHour10(43000);
		carModel.setHour12(49000);
		carModel.setHourElse(60000);
		Fuel fuel = new Fuel();
		fuel.setCode("lpg");
		carModel.setFuel(fuel);
		carModel.setRent(false);
		carModel.setRentCnt(0);
		
		int res = dao.updateCarModel(carModel);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test02deleteCarModel() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarModel carModel = new CarModel();
		carModel.setCarCode("V019");
		int res = dao.deleteCarModel(carModel);
		Assert.assertEquals(1, res);
	}
	
	/*@Test
	public void test06selectCarModelWithCarOptionByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<CarModel> list = dao.selectCarModelWithCarOptionByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test07selectCarModelWithCarOptionByCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CarModel model = new CarModel();
		model.setCarCode("V003");
		List<CarModel> searchModel = dao.selectCarModelWithCarOptionByCode(model);
		Assert.assertNotNull(searchModel);
	}
	*/
	
	@Test
	public void test08selectCarModelByCarType() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<CarModel> list = dao.selectCarModelByCarType(new CarType("S2"));
		Assert.assertNotNull(list);
		
	}
	
	@Test
	public void test09SelectCarModelWithWhere() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, String> maps = new HashMap<>();
		maps.put("cartype","S2");
		maps.put("brand", "b2");
		maps.put("gear", "auto");
		List<CarModel> list = dao.SelectCarModelWithWhere(maps);
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test10nextCarCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		String carCode = dao.nextCarCode();
		Assert.assertNotNull(carCode);
	}
	
}
















