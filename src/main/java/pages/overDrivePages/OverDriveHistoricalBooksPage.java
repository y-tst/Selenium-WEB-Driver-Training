package pages.overDrivePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class OverDriveHistoricalBooksPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-header__title']")
    private WebElement pageHeaderTitle;

    public OverDriveHistoricalBooksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected OverDriveHistoricalBooksPage pageOpener() {
        return this;
    }

    public String historicalBooksPageTitle() {
        return pageHeaderTitle.getText();
    }
}