package com.jsonplaceholder.testing.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.BaseTest;
import com.jsonplaceholder.testing.utils.JsonFileReader;

import net.minidev.json.JSONObject;
@Tag("Posts")
public class PostsApiPositiveTest extends BaseTest{
	
	private Posts posts;
	
	@BeforeAll
	public void beforeAll() {
		posts = new Posts();
		
		jsonReader = new JsonFileReader();
		 
	}
	
	@Test
	public void testGetByUserIDFunctionalityOfPostsAPI() {
		posts.getResponseByUserID("3").then().assertThat().statusCode(200);
		List<Integer> userIdList =posts.getListOfValuesOfUserIDInResponse();
		userIdList.stream().forEach(userId -> assertEquals(userId,3));
	}
	
	@Test
	public void testPostFunctionalityOfPostsAPI() {
		JSONObject request= jsonReader.parseJson("posts");
		posts.postRequest(request).then().assertThat().statusCode(200);
	}

}
