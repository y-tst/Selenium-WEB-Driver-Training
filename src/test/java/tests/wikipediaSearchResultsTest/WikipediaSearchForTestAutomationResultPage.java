package tests.wikipediaSearchResultsTest;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WikipediaHomePage;

public class WikipediaSearchForTestAutomationResultPage extends BaseTest {

    @Test
    public void searchForTestAutomationCheck() {

        String expectedTitleContentForTestAutomationSearch = new WikipediaHomePage(driver)
                .pageOpener()
                .WikiSearchForTerms("Test Automation")
                .wikipediaSearchPageTitle();

        Assert.assertEquals(expectedTitleContentForTestAutomationSearch, "Поиск «Test Automation» — Википедия", "Search result doesn't contain 'Test automation'");

        logger.info(String.format("Wiki search for Test automation page result -  '%s'", expectedTitleContentForTestAutomationSearch));
    }
}


