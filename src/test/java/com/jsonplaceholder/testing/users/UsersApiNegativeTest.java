package com.jsonplaceholder.testing.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jsonplaceholder.testing.BaseTest;

@Tag("Users")
public class UsersApiNegativeTest extends BaseTest{
	
	@Autowired
	private Users users;
	
	@Test
	public void testNoRecordPresentForGivenUserName() {
		users.getResponseByUserName("samantha").then().assertThat().statusCode(200);
		List<Integer> userIdList =users.getListOfValuesOfIDInResponse();
		assertEquals(0,userIdList.size());
	}
}
