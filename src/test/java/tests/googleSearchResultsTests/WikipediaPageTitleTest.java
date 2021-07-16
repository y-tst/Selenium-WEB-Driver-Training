package tests.googleSearchResultsTests;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlePages.GoogleHomePage;

public class WikipediaPageTitleTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck() {

        String expectedGoogleForWikipediaSearchPagetitle = new GoogleHomePage(driver)
                .pageOpener()
                .searchForTerms("wikipedia")
                .wikipediaPageTitle();

        logger.info(String.format("Wiki page title is '%s', it has length: %s symbols", expectedGoogleForWikipediaSearchPagetitle, expectedGoogleForWikipediaSearchPagetitle.length()));

        Assert.assertTrue(expectedGoogleForWikipediaSearchPagetitle.contains("Google"), "Different from the main Wiki page is opened");
    }
}