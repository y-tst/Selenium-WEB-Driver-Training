package pages.googlePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GoogleHomePage extends BasePage {

    private static final String GOOGLE_HOMEPAGE_URL = "https://www.google.com/";

    @FindBy(name = "q")
    private WebElement googleSearchField;

    @FindBy(name = "btnK")
    private WebElement googleSearchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleHomePage pageOpener() {
        driver.get(GOOGLE_HOMEPAGE_URL);
        waitForPageLoad();

        return this;
    }

    public GoogleSearchForWikipediaResultsPage searchForTerms(String searchTerm) {
        googleSearchField.sendKeys(searchTerm);
        googleSearchButton.submit();

        return new GoogleSearchForWikipediaResultsPage(driver);
    }
}