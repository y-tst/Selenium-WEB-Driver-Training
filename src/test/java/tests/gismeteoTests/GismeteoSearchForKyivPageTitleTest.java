package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoSearchForKyivPageTitleTest extends BaseTest {

    @Test
    public void gismeteoPageTitleForKyivCheck() {

        String pageTytleForKyivWeather = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .searchResultPageTitle();

        logger.info(String.format("Wiki page title is '%s', it has length: %s symbols", pageTytleForKyivWeather, pageTytleForKyivWeather.length()));

        Assert.assertTrue(pageTytleForKyivWeather.contains("GISMETEO: Погода в Киеве сегодня"), "Wrong page title for Kyiv weather");
    }
}