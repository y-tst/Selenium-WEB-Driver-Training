package pages.overDrivePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class OverDriveHomePage extends BasePage {

    private static final String OVERDRIVE_HOMEPAGE_URL = "https://www.overdrive.com/";

    @FindBy(xpath = "//li[@id='account-trigger']")
    private WebElement userIcon;

    public OverDriveHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OverDriveHomePage pageOpener() {
        driver.get(OVERDRIVE_HOMEPAGE_URL);
        waitForPageLoad();

        return this;
    }

    public String userNameOnOverDrivePage() {
        waitForElementVisibility(userIcon);

        return userIcon.getText();
    }
}