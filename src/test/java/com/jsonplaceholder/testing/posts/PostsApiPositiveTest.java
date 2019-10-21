package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jsonplaceholder.testing.BaseTest;
import com.jsonplaceholder.testing.utils.JsonFileReader;

import net.minidev.json.JSONObject;

public class PostsApiPositiveTest extends BaseTest{
	
	@Autowired
	private Posts posts;
	
	@Autowired
	private JsonFileReader jsonFileReader;
	
	@Test
	public void testGetByUserIDFunctionalityOfPostsAPI() {
		posts.getResponseByUserID("3").then().assertThat().statusCode(200);
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		userIdList.stream().forEach(userId -> assertEquals(userId,3));
	}
	
	@Test
	public void testGetByPostIDReturnsUniqueRecordOfPostsAPI() {
		posts.getResponseByPostID("1").then().assertThat().statusCode(200);
		List<Integer> userIdList =posts.getListOfValuesOfPostIDInResponse();
		assertEquals(1,userIdList.size());
	}

	@Test
	@Tag("runThis")
	public void testPostFunctionalityOfPostsAPI() {
		System.out.println("Reading from json file");
		JSONObject request= jsonFileReader.parseJson("posts");
		posts.postRequest(request).then().assertThat().statusCode(201);
	}

}
