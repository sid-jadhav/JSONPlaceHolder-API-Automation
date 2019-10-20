package com.jsonplaceholder.testing.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jsonplaceholder.testing.api.RestTemplateUtil;

import io.restassured.response.Response;

@Component
public class Users extends RestTemplateUtil{
	
	
	@Value("${users}")
	private String ENDPOINT;
	
	private static final String USER_ID= "id";
	
	private static final String USER_NAME = "username";
	
	private Response response;
	
	public Response getResponse() {
		return response;
	}

	public Response getResponseByUserName(String name) {
		Map<String, String> param = new HashMap<String, String>();
		param.put(USER_NAME, name);
		response = executeGet(ENDPOINT, param);
		System.out.println(response.body().asString());
		return response;
	}
	
	public List<Integer> getListOfFieldInResponse(String fieldName) {
		return response.jsonPath().getList(fieldName);
	}

}

