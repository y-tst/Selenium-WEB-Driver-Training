package tests.jQueryUITests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.jQueryUIPages.JQueryUAHomePage;
import tests.BaseTest;

public class JQueryUIPageURLTest extends BaseTest {

    @Test
    public void draggableElementPageURLCheck() {

        String draggableSimulator = new JQueryUAHomePage(driver)
                .pageOpener()
                .draggableSimulatorURL();

        logger.info(String.format("URL for Draggable elements simulator ", draggableSimulator));

        Assert.assertEquals(draggableSimulator, "https://jqueryui.com/draggable/", "Incorrect URL for Draggable elements simulator");
    }
}
