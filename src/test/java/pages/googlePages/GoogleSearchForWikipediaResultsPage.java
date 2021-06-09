package pages.googlePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class GoogleSearchForWikipediaResultsPage extends BasePage {

    @FindBy(xpath = "(//div[contains(@class, 'g')])[1]")
    private List<WebElement> generalGoogleForWikipediaSearchResult;

    @FindBy(xpath = "//*[@id='rso']//a/h3")
    private WebElement firstWikiLinkFromGoogleSearch;

    public GoogleSearchForWikipediaResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GoogleSearchForWikipediaResultsPage pageOpener() {
        return this;
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
}