package kr.or.yi.java_web_female;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.java_web_female.dao.PostMapper;
import kr.or.yi.java_web_female.dao.PostMapperImpl;
import kr.or.yi.java_web_female.dto.Post;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PostMapperTest extends AbstractTest {
	private PostMapper dao = PostMapperImpl.getInstance();

	@Test
	public void test01selectPostByName() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Post searchPost = new Post();
		searchPost.setSido("대구광역시");
		searchPost.setDoro("태전로7길");

		List<Post> searchedPost = dao.selectPostByName(searchPost);
		for (Post p : searchedPost) {
			System.out.println(p);
		}
		Assert.assertNotNull(searchedPost);
	}

}