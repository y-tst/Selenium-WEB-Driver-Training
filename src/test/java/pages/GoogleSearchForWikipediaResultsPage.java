package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchForWikipediaResultsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'g')]")
    private List<WebElement> generalGoogleForWikipediaSearchResult;

    @FindBy(xpath = "//*[@id='rso']//a/h3")
    private WebElement firstWikiLinkFromGoogleSearch;

    public GoogleSearchForWikipediaResultsPage(WebDriver driver) {
        super(driver);
    }

    public int countGeneralNumberOfSearchResults() {
        return generalGoogleForWikipediaSearchResult.size();
    }

    public String wikipediaPageTitle() {
        return driver.getTitle();
    }

    public String searchResultPageUrl() {
        return driver.getCurrentUrl();
    }

    public int searchResultLength() {
        return driver.getTitle().length();
    }

    public GoogleSearchForWikipediaResultsPage openWikipediaPage() {
        firstWikiLinkFromGoogleSearch.click();
        return this;
    }

    @Override
    public GoogleSearchForWikipediaResultsPage pageOpener() {
        return this;
    }
}
