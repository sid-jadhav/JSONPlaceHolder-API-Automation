package com.jsonplaceholder.testing.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestTemplateUtil {
	
	String baseURI = "https://jsonplaceholder.typicode.com/";
	
	protected Response executeGet(String endpoint, Map<String, String> params) {
		
        return given()
                .contentType(ContentType.JSON)
                .baseUri(baseURI)
                .headers(createHeaders())
                .params(params)
                .get(endpoint);
		
	}

	private Map<String, ?> createHeaders() {
		Map<String, Object> headers= new HashMap<String, Object>();
		return headers;
	}
}

