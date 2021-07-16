package tests.googleSearchResultsTests;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.googlePages.GoogleHomePage;

public class GoogleSearchResultLengthTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck() {

        int searchResultPageLength = new GoogleHomePage(driver)
                .pageOpener()
                .searchForTerms("wikipedia")
                .searchResultLength();

        logger.info(String.format("Wiki page length has %s symbols", searchResultPageLength));

        Assert.assertTrue(searchResultPageLength > 0, "Google Search for 'wikipedia' result has zero length");
    }
}