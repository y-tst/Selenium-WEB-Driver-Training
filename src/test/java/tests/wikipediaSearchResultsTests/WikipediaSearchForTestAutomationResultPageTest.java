package tests.wikipediaSearchResultsTests;

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

        Assert.assertTrue(expectedTitleContentForTestAutomationSearch.contains("Test Automation"), "Search result doesn't contain 'Test automation'");
    }
}