package tests.googleSearchResultsTests;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlePages.GoogleHomePage;

public class WikipediaUrlTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck() {

        String googleForWikipediaSearchPageUrl = new GoogleHomePage(driver)
                .pageOpener()
                .searchForTerms("wikipedia")
                .searchResultPageUrl();

        logger.info(String.format("Google search for 'wikipedia' result page URL is %s ", googleForWikipediaSearchPageUrl));

        Assert.assertTrue(googleForWikipediaSearchPageUrl.contains("wikipedia"), "Incorrect URL for Wiki page");
    }
}