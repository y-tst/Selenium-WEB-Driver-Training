package tests.overDriveTests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.overDrivePages.OverDriveSignInPage;
import service.UserCreator;
import tests.BaseTest;

public class OverDriveUserAccessTest extends BaseTest {
	@Test
	public void signInWithCredentialsCheck()
	{

		User testUser = UserCreator.withCredentialsFromProperty();

		String loggedInUserName = new OverDriveSignInPage(driver)
				.pageOpener()
				.loginUserUsingUserNameAndPassword(testUser)
				.userNameOnOverDrivePage();

		logger.info(String.format("Checking if signed in user has correct name - %s", testUser.getUsername()));

		Assert.assertEquals(loggedInUserName, testUser.getUsername(), "Sign in went wrong");
	}
}