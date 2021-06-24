package pages.overDrivePages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class OverDriveSignInPage extends BasePage {

    private static final String OVERDRIVE_SIGN_IN_PAGE_URL = "https://www.overdrive.com/account/sign-in?returnUrl=%2Faccount%2Fsign-in";

    @FindBy(xpath = "//input[@id='UserName']")
    private WebElement userNameInputField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement userPasswordInputField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitCredentialsButton;

    public OverDriveSignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the sign in page")
    @Override
    public OverDriveSignInPage pageOpener() {
        driver.get(OVERDRIVE_SIGN_IN_PAGE_URL);
        waitForPageLoad();
        waitForElementVisibility(userNameInputField);

        return this;
    }

    @Step("Sign in OverDive online library using correct credentials")
    public OverDriveHomePage loginUserUsingUserNameAndPassword(User user) {
        userNameInputField.sendKeys(user.getUsername());
        userPasswordInputField.sendKeys(user.getPassword());
        submitCredentialsButton.submit();

        logger.info("Login to OverDrive library is performed");

        return new OverDriveHomePage(driver);
    }
}