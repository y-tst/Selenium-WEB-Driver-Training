package tests.wikipediaSearchResultsTest;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wikipediaPages.WikipediaHomePage;

public class WikipediaSearchForTestAutomationResultPageTest extends BaseTest {

    @Test
    public void searchForTestAutomationCheck() {

        String expectedTitleContentForTestAutomationSearch = new WikipediaHomePage(driver)
                .pageOpener()
                .WikiSearchForTerms("Test Automation")
                .wikipediaSearchPageTitle();

        logger.info(String.format("Wiki search for Test automation page result -  '%s'", expectedTitleContentForTestAutomationSearch));

        Assert.assertEquals(expectedTitleContentForTestAutomationSearch, "Поиск «Test Automation» — Википедия", "Search result doesn't contain 'Test automation'");
    }
}