package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage {

    private static final String GOOGLE_HOMEPAGE_URL = "https://www.google.com/";
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement googleSearchField;

    @FindBy(name = "btnK")
    private WebElement googleSearchButton;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public GoogleHomePage openGooglePage() {
        pageOpener(GOOGLE_HOMEPAGE_URL);
        return this;
    }

    public GoogleSearchForWikipediaResultsPage searchForTerms(String searchTerm) {
        pageOpener(GOOGLE_HOMEPAGE_URL);
        googleSearchField.sendKeys(searchTerm);
        googleSearchButton.submit();
        return new GoogleSearchForWikipediaResultsPage(driver, searchTerm);
    }
}
