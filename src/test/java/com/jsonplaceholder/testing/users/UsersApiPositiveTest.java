package com.jsonplaceholder.testing.users;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.BaseTest;

public class UsersApiPositiveTest extends BaseTest{
	
	private Users users;
	
	@BeforeAll
	public void beforeAll() {
		users = new Users();
	}
	
	@Test
	public void testUniqueRecordPresentForUserNameSamantha() {
		users.getResponseByUserName("Samantha");
		List<Integer> userIdList =users.getListOfValuesOfIDInResponse();
		assertAll(
				() -> assertFalse( 0 == userIdList.size(),"User Named Samantha Does Not exists"),
				() -> assertTrue(1 == userIdList.size(),"Multiple Records found for user name Samantha")
				);
	}
	
	@Test
	public void testGetByUserNameFunctionalityOfUsersAPI() {
		users.getResponseByUserName("Samantha");
		List<String> userNameList =users.getListOfValuesOfUserNameInResponse();
		userNameList.stream().forEach(userName -> assertEquals(userName,"Samantha"));
	}
}
