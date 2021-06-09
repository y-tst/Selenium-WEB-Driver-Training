package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoKyivWeatherTest extends BaseTest {

    @Test
    public void gismeteoKyivWeatherPageSubtitleCheck() {

        String kyivWeatherSubtitle = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .kyivWeatherPageAknowledge();

        logger.info(String.format("Checking the subtitle for Kyiv Weather Page"));

        Assert.assertEquals(kyivWeatherSubtitle, "Погода в Киеве", "Current page is not for Kyiv Weather");
    }
}