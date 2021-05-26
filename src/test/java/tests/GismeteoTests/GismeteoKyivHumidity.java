package tests.GismeteoTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GismeteoHomePage;
import tests.BaseTest;

public class GismeteoKyivHumidity extends BaseTest {

    @Test
    public void gismeteoKyivWeatherHumidityPresenceCheck() {

        String humidityOnKyivWeatherPage = new GismeteoHomePage(driver)
                .pageOpener()
                .searchForGismeteoTerm("Киев")
                .humidityNameOnKyivWeatherPage();

        Assert.assertEquals(humidityOnKyivWeatherPage, "Влажность", "Humidity parameter is absent on Kiyv Weather Page");

        logger.info(String.format("Humidity parameter is present on Kiyv Weather Page"));
    }
}
