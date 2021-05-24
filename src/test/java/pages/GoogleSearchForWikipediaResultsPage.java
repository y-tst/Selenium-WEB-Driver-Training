package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchForWikipediaResultsPage extends BasePage {

    private String searchTerm;

    private String wikiRelatedLocator = "//div[contains(@class, 'g') and contains(., 'wikipedia')]";

    @FindBy(xpath = "//div[contains(@class, 'g')")
    private List<WebElement> generalGoogleForWikipediaSearchResult;

    @FindBy(xpath = "//*[@id='rso']//a/h3")
    private WebElement firstWikiLinkFromGoogleSearch;

    public GoogleSearchForWikipediaResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
}
