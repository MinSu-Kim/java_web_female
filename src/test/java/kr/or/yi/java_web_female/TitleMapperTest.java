package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import kr.or.yi.java_web_female.dao.TitleMapper;
import kr.or.yi.java_web_female.dao.TitleMapperImpl;
import kr.or.yi.java_web_female.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleMapperTest  extends AbstractTest{
	private TitleMapper dao = TitleMapperImpl.getInstance();
	
	@Test
	public void test01selectTitleByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title searchTit = new Title();
		searchTit.setCode("T001");
		
		Title searchedTit = dao.selectTitleByNo(searchTit);
		Assert.assertNotNull(searchedTit);
	}
	
	@Test
	public void test02selectTitleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Title> titList = dao.selectTitleByAll();
		Assert.assertNotNull(titList);
	}
	
	@Test
	public void test03insertTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setCode("T003");
		title.setName("인턴");
		title.settGrant(false);
		int res = dao.insertTitle(title);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test04updateTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setCode("T003");
		title.setName("알바");
		title.settGrant(false);
		
		int res = dao.updateTitle(title);
		Assert.assertSame(1, res);

	}
	@Test
	public void test05deleteTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Title title = new Title();
		title.setCode("T003");
		int res = dao.deleteTitle(title);
		Assert.assertEquals(1, res);
	}
}
