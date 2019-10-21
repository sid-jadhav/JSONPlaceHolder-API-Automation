package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jsonplaceholder.testing.BaseTest;
@Tag("Posts")
public class PostsApiNegativeTest extends BaseTest{
	
	@Autowired
	private Posts posts;
	
	@Test
	public void testGetByPostIDThatIsNotPresentOnSerevrReturnsNoRecord() {
		posts.getResponseByUserID("Random").then().assertThat().statusCode(200);
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		assertEquals(0,userIdList.size());
	}

}
