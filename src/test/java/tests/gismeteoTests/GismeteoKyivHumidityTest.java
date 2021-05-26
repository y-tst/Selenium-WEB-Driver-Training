package tests.gismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.gismeteoPages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoKyivHumidityTest extends BaseTest {

    @Test
    public void gismeteoKyivWeatherHumidityPresenceCheck() {

        String humidityOnKyivWeatherPage = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .humidityNameOnKyivWeatherPage();

        logger.info(String.format("Check of presence the Humidity parameter on Kiyv Weather Page"));

        Assert.assertEquals(humidityOnKyivWeatherPage, "Влажность", "Humidity parameter is absent on Kiyv Weather Page");
    }
}