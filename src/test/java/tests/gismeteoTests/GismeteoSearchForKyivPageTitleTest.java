package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

import java.io.UnsupportedEncodingException;

public class GismeteoSearchForKyivPageTitleTest extends BaseTest {

    @Test
    public void gismeteoPageTitleForKyivCheck() throws UnsupportedEncodingException, InterruptedException {

        String pageTytleForKyivWeather = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .searchResultPageTitle();

        logger.info(String.format("Gismeteo Kyiv weather page title is '%s', it has length: %s symbols", pageTytleForKyivWeather, pageTytleForKyivWeather.length()));

        Assert.assertTrue((new String(pageTytleForKyivWeather.getBytes("UTF-8"), "UTF-8")).contains("GISMETEO: Погода в Киеве сегодня"), "Wrong page title for Kyiv weather");
    }
}