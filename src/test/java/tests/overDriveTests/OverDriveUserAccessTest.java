package tests.overDriveTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.overDrivePages.OverDriveSignInPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import service.UserCreator;
import tests.BaseTest;

@Features("OverDrive sign in feature")
public class OverDriveUserAccessTest extends BaseTest {

	@Title("Sign In test for OneDrive online library")
	@Description("OverDrive sign in test for registered previously user with valid credentials")
	@Stories("Basic functionality")
	@Test
	public void signInWithCredentialsCheck(){

		String loggedInUserName = new OverDriveSignInPage(driver)
				.pageOpener()
				.loginUserUsingUserNameAndPassword(UserCreator.withCredentialsFromProperty())
				.userNameOnOverDrivePage();

		logger.info(String.format("Checking if signed in user has correct name - %s", UserCreator.withCredentialsFromProperty().getUsername()));

		Assert.assertEquals(loggedInUserName, UserCreator.withCredentialsFromProperty().getUsername(), "Sign in went wrong");
	}
}