package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.GradeMapper;
import kr.or.yi.java_web_female.dao.GradeMapperImpl;
import kr.or.yi.java_web_female.dto.Grade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GradeMapperTest extends AbstractTest {
	private GradeMapper dao = GradeMapperImpl.getInstance();

	@Test
	public void test01selectGradeByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Grade searchGrad = new Grade();
		searchGrad.setCode("G001");

		Grade searchedGrad = dao.selectGradeByNo(searchGrad);
		Assert.assertNotNull(searchedGrad);
	}

	@Test
	public void test02selectGradeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Grade> gradList = dao.selectGradeByAll();
		Assert.assertNotNull(gradList);
	}

	@Test
	public void test03insertGrade() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Grade grade = new Grade();
		grade.setCode("G005");
		grade.setName("다이아");
		grade.setgLosal(15);
		grade.setgHisal(20);
		grade.setRate(25);
		int res = dao.insertGrade(grade);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04updateGrade() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Grade grade = new Grade();
		grade.setCode("G005");
		grade.setName("더블골드");
		grade.setgLosal(0);
		grade.setgHisal(0);
		grade.setRate(23);

		int res = dao.updateGrade(grade);
		Assert.assertSame(1, res);

	}

	@Test
	public void test05deleteGrade() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Grade grade = new Grade();
		grade.setCode("G005");
		int res = dao.deleteGrade(grade);
		Assert.assertEquals(1, res);
	}
}
