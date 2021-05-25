package pages;

import org.openqa.selenium.WebDriver;

public class WikipediaSearchForTestAutomationResultsPage extends BasePage {

    public WikipediaSearchForTestAutomationResultsPage(WebDriver driver) {
        super(driver);
        return;
    }

    public String wikipediaSearchPageTitle() {
        return driver.getTitle();
    }

    @Override
    protected WikipediaSearchForTestAutomationResultsPage pageOpener() {
        return this;
    }
}

