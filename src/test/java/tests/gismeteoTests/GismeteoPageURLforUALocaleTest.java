package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoPageURLforUALocaleTest extends BaseTest {

    @Test
    public void gismeteoUALocalemainPageCheck() {

        String localeUAPage = new GismeteoHomePage(driver)
                .pageOpener()
                .switchToLocaleUA();

        logger.info(String.format("URL for UA locale Gismeteo main page is %s ", localeUAPage));

        Assert.assertEquals(localeUAPage, "https://www.gismeteo.ua/ua/", "Incorrect URL for UA locale Gismeteo main page");
    }
}