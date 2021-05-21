package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaHomePage extends BasePage {

    private static final String WIKIPEDIA_HOMEPAGE_URL = "https://ru.wikipedia.org";

    private WebDriver driver;

    @FindBy(name = "search")
    private WebElement wikiSearchField;

    @FindBy(xpath = "(//div[contains(@id,'main-dyk')]//img)[1]")
    private WebElement imageForStandardScreenshot;

    @FindBy(xpath = "(//div[contains(@id,'main-dyk')]//img)[2]")
    private WebElement imageForAShot;

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public WikipediaHomePage openWikipediaPage() {
        pageOpener(WIKIPEDIA_HOMEPAGE_URL);
        return this;
    }

    public WikipediaSearchForTestAutomationResultsPage WikiSearchForTerms(String searchWikiTerm) {
        pageOpener(WIKIPEDIA_HOMEPAGE_URL);
        wikiSearchField.sendKeys(searchWikiTerm);
        wikiSearchField.submit();
        return new WikipediaSearchForTestAutomationResultsPage(driver, searchWikiTerm);
    }

    public int getImageHeightForStandardScreenShot() {
        return imageForStandardScreenshot.getSize().getHeight();
    }
}
