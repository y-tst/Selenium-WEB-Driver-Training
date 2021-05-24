package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchForTestAutomationResultsPage extends BasePage {

    private String searchWikiTerm;

    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver, String searchWikiTerm) {
        super(driver);
        this.searchWikiTerm = searchWikiTerm;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String wikipediaSearchPageTitle() {
        return driver.getTitle();
    }
}

