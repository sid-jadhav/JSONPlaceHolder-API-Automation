package com.jsonplaceholder.testing;

import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jsonplaceholder.testing.comments.Comments;
import com.jsonplaceholder.testing.posts.Posts;
import com.jsonplaceholder.testing.users.Users;

public class FreeNowApiChallengeTest extends BaseTest{
	
protected static Logger LOG = Logger.getLogger(FreeNowApiChallengeTest.class);
	
	private Users user;
	
	private Posts posts;
	
	private Comments comments;
	
	SoftAssertions softAssert;
	
	@BeforeAll
	public void beforeAll() {
		softAssert = new SoftAssertions();
		comments = new Comments();
		user = new Users();
		posts = new Posts();
	}
	
	@Test
	@DisplayName("Validate the format of Emails in comments section for all posts of a user")
	public void testValidateFormatOfEmailsInCommentsSectionForAllPostsOfAUser() {
		user.getResponseByUserName("Samantha");
		List<Integer> userIdList= user.getListOfValuesOfIDInResponse();
		for(Integer userId: userIdList) {
			posts.getResponseByUserID(userId.toString());
			List<Integer> postIdList = posts.getListOfValuesOfUserIDInResponse();
			
			for(Integer PostId: postIdList) {
				comments.getResponseByPostID(PostId.toString());
				List<String> emails= comments.getListOfValuesOfEmailsInResponse();
				emails.stream().forEach(email->softAssert.assertThat(comments.isValid(email)).isTrue());
				softAssert.assertAll();
			}
		}
		
	}

}
