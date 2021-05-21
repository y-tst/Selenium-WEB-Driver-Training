package test.googleSearchResultsTest;

import test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleHomePage;

public class GoogleSearchResultLengthTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck(){

        int searchResultPageLength = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .searchResultLength();

        Assert.assertTrue(searchResultPageLength > 0, "Google Search for 'wikipedia' result has zero length");

        logger.info(String.format("Wiki page length has %s symbols", searchResultPageLength));

    }
}
