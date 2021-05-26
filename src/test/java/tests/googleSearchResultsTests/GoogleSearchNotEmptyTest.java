package tests.googleSearchResultsTests;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlePages.GoogleHomePage;

public class GoogleSearchNotEmptyTest extends BaseTest {

    @Test
    public void searchResultNotEmptyCheck() {
        int expectedGoogleSearchResultForWikipediaNumber = new GoogleHomePage(driver)
                .pageOpener()
                .searchForTerms("wikipedia")
                .countGeneralNumberOfSearchResults();

        logger.info(String.format("Number of pages found: %s", expectedGoogleSearchResultForWikipediaNumber));

        Assert.assertTrue(expectedGoogleSearchResultForWikipediaNumber > 0, "Empty result for 'Wikipedia' search");
    }
}