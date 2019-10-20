package com.jsonplaceholder.testing.users;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jsonplaceholder.testing.BaseTest;

public class UsersApiPositiveTest extends BaseTest{
	
	@Autowired
	private Users users;
	
	@Test
	public void testUniqueRecordPresentForUserNameSamantha() {
		users.getResponseByUserName("Samantha");
		List<Integer> userId =users.getListOfFieldInResponse("id");
		assertAll(
				() -> assertFalse( 0 == userId.size(),"User Named Samantha Does Not exists"),
				() -> assertTrue(1 == userId.size(),"Multiple Records found for user name Samantha")
				);
	}
}
