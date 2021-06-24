package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

import java.io.UnsupportedEncodingException;

public class GismeteoKyivWeatherTest extends BaseTest {

    @Test
    public void gismeteoKyivWeatherPageSubtitleCheck() throws UnsupportedEncodingException, InterruptedException {

        String kyivWeatherSubtitle = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .kyivWeatherPageAcknowledge();
        logger.info(String.format("Checking the subtitle for Kyiv Weather Page"));

        Assert.assertEquals(new String(kyivWeatherSubtitle.getBytes("UTF-8"), "UTF-8"), "Погода в Киеве", "Current page is not for Kyiv Weather");
    }
}