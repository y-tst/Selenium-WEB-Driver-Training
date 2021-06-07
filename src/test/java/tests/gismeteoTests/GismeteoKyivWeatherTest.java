package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoKyivWeatherTest extends BaseTest {

    @Test
    public void gismeteoKyivWeatherHumidityPresenceCheck() {

        String humidityOnKyivWeatherPage = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .gismeteoPageSubtitle();

        logger.info(String.format("Checking the subtitle for Kiyv Weather Page"));

        Assert.assertEquals(humidityOnKyivWeatherPage, "Киев", "Current page is not for Kiyv Weather");
    }
}