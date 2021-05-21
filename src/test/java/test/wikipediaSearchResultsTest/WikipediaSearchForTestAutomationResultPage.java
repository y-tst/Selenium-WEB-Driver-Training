package test.wikipediaSearchResultsTest;

import test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.WikipediaHomePage;

public class WikipediaSearchForTestAutomationResultPage extends BaseTest {

    @Test
    public void searchForTestAutomationCheck(){

        String expectedTitleContentForTestAutomationSearch = new WikipediaHomePage(driver)
                .openWikipediaPage()
                .WikiSearchForTerms("Test Automation")
                .wikipediaSearchPageTitle();

        Assert.assertEquals(expectedTitleContentForTestAutomationSearch, "Поиск «Test Automation» — Википедия", "Search result doesn't contain 'Test automation'");

        logger.info(String.format("Wiki search for Test automation page result -  '%s'", expectedTitleContentForTestAutomationSearch));
    }
}


