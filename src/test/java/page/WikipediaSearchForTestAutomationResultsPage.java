package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchForTestAutomationResultsPage extends BasePage {

    private WebDriver driver;
    private String searchWikiTerm;

    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver, String searchWikiTerm) {
        this.searchWikiTerm = searchWikiTerm;
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String wikipediaSearchPageTitle() {
        return driver.getTitle();
    }
}

