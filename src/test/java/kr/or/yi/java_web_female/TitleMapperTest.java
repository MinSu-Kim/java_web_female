package kr.or.yi.java_web_female;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import kr.or.yi.java_web_female.dao.TitleMapper;
import kr.or.yi.java_web_female.dao.TitleMapperImpl;
import kr.or.yi.java_web_female.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleMapperTest  extends AbstractTest{
	private TitleMapper dao = new TitleMapperImpl();
	
	@Test
	public void test01selectTitleByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title searchTit = new Title();
		searchTit.setCode("T0001");
		
		Title searchedTit = dao.selectTitleByNo(searchTit);
		Assert.assertNotNull(searchedTit);
	}

}
