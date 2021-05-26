package tests.GismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoPageURLforUALocaleTest extends BaseTest {

    @Test
    public void gismeteoUALocalemainPageCheck() {

        String localeUAPage = new GismeteoHomePage(driver)
                .pageOpener()
                .switchToLocaleUA();

        Assert.assertEquals(localeUAPage, "https://www.gismeteo.ua/ua/", "Incorrect URL for UA locale Gismeteo main page");

        logger.info(String.format("URL for UA locale Gismeteo main page is %s ", localeUAPage));

    }
}
