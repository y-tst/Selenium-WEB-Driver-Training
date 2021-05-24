package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement googleSearchField;

    @FindBy(name = "btnK")
    private WebElement googleSearchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public GoogleSearchForWikipediaResultsPage searchForTerms(String searchTerm) {
        pageOpener(BasePage.GOOGLE_HOMEPAGE_URL);
        googleSearchField.sendKeys(searchTerm);
        googleSearchButton.submit();
        return new GoogleSearchForWikipediaResultsPage(driver, searchTerm);
    }
}
