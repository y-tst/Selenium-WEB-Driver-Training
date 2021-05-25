package tests.wikipediaMainPageTest;

import pages.WikipediaHomePage;
import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class WikipediaPageTitleTest extends BaseTest {

    @Test
    public void googleSearchIsCorrectCheck() {

        String expectedGoogleForWikipediaSearchPagetitle = new GoogleHomePage(driver)
                .pageOpener()
                .searchForTerms("wikipedia")
                .wikipediaPageTitle();

        Assert.assertEquals(expectedGoogleForWikipediaSearchPagetitle, "wikipedia - Пошук Google", "Different from the main Wiki page is opened");

        logger.info(String.format("Wiki page title is '%s', it has length: %s symbols", expectedGoogleForWikipediaSearchPagetitle, expectedGoogleForWikipediaSearchPagetitle.length()));
    }
}
