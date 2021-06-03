package pages.wikipediaPages;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class WikipediaSearchForTestAutomationResultsPage extends BasePage {

    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver) {
        super(driver);
    }

    public String wikipediaSearchPageTitle() {
        return driver.getTitle();
    }

    @Override
    protected WikipediaSearchForTestAutomationResultsPage pageOpener() {

        return this;
    }
}