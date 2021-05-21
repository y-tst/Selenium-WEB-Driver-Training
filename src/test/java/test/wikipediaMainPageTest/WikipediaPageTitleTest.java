package test.wikipediaMainPageTest;

import test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleHomePage;

public class WikipediaPageTitleTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck(){

        String expectedGoogleForWikipediaSearchPagetitle = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .wikipediaPageTitle();

        Assert.assertEquals(expectedGoogleForWikipediaSearchPagetitle, "Википедия — свободная энциклопедия", "Different from the main Wiki page is opened");

        logger.info(String.format("Wiki page title is '%s', it has length: %s symbols", expectedGoogleForWikipediaSearchPagetitle, expectedGoogleForWikipediaSearchPagetitle.length()));

    }
}
