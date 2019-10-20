package com.jsonplaceholder.testing.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestTemplateUtil {
	
	@Value("${base.uri}")
	String baseURI;
	
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

