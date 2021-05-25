package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaHomePage extends BasePage {

    private static final String WIKIPEDIA_HOMEPAGE_URL = "https://ru.wikipedia.org";

    @FindBy(name = "search")
    private WebElement wikiSearchField;

    @FindBy(xpath = "(//div[contains(@id,'main-dyk')]//img)[1]")
    private WebElement imageForStandardScreenshot;

    @FindBy(xpath = "(//div[contains(@id,'main-dyk')]//img)[2]")
    private WebElement imageForAShot;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WikipediaHomePage pageOpener() {
        driver.get(WIKIPEDIA_HOMEPAGE_URL);
        driver.manage().window().maximize();
        waiter(driver);
        return this;
    }

    public WikipediaHomePage openWikipediaPage() {
        return this;
    }

    public WikipediaSearchForTestAutomationResultsPage WikiSearchForTerms(String searchWikiTerm) {
        wikiSearchField.sendKeys(searchWikiTerm);
        wikiSearchField.submit();
        return new WikipediaSearchForTestAutomationResultsPage(driver);
    }

    public int getImageHeightForStandardScreenShot() {
        return imageForStandardScreenshot.getSize().getHeight();
    }
}
