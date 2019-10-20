package com.jsonplaceholder.testing.posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jsonplaceholder.testing.api.RestTemplateUtil;

import io.restassured.response.Response;
@Component
public class Posts extends RestTemplateUtil{
	
	@Value("${posts}")
	private String ENDPOINT;
	
	private static final String POST_ID= "id";
	
	private static final String USER_ID = "userId";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}
	
	public Response getResponseByUserID(String ID) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put(USER_ID, ID);
		response = executeGet(ENDPOINT, param);
		return response;
	}
	
	public List<Integer> getListOfValuesOfUserIDInResponse() {
		return response.jsonPath().getList(USER_ID);
	}
	
	public List<Integer> getListOfValuesOfPostIDInResponse() {
		return response.jsonPath().getList(POST_ID);
	}
}

