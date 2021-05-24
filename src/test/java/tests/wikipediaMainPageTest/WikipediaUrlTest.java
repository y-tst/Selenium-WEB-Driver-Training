package tests.wikipediaMainPageTest;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class WikipediaUrlTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck() {

        String googleForWikipediaSearchPageUrl = new GoogleHomePage(driver)
                .searchForTerms("wikipedia")
                .searchResultPageUrl();

        Assert.assertTrue(googleForWikipediaSearchPageUrl.contains("wikipedia"), "Incorrect URL for Wiki page");

        logger.info(String.format("Google search for 'wikipedia' result page URL is %s ", googleForWikipediaSearchPageUrl));
    }
}
