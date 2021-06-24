package tests.jQueryUIremoteDriverTests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.jQueryUIPages.JQueryUAHomePage;
import tests.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class JQueryUIPageURLRemoteWebDriverTest extends BaseTest {

    @Test
    public void jQueryUIPageURLForDraggableElementCheck() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);
        desiredCapabilities.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);

        String draggableSimulator = new JQueryUAHomePage(driver)
                .pageOpener()
                .draggableSimulatorURL();

        logger.info(String.format("URL for Draggable elements simulator ", draggableSimulator));

        Assert.assertEquals(draggableSimulator, "https://jqueryui.com/draggable/", "Incorrect URL for Draggable elements simulator");
    }
}