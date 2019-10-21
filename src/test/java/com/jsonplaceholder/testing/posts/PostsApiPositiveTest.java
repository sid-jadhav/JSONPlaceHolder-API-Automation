package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.BaseTest;

public class PostsApiPositiveTest extends BaseTest{
	
	private Posts posts;
	
	@BeforeAll
	public void beforeAll() {
		posts = new Posts();
	}
	
	@Test
	public void testGetByUserIDFunctionalityOfPostsAPI() {
		posts.getResponseByUserID("3");
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		userIdList.stream().forEach(userId -> assertEquals(userId,3));
	}

}
