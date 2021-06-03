package tests.jQueryUITests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.jQueryUIPages.JQueryUAHomePage;
import tests.BaseTest;

public class BasicDraggableTest extends BaseTest {

    private int xOffset = 50;
    private int yOffset = 45;


    @Test
    public void basicDraggingCheck() throws InterruptedException {

        int[] draggableSimulator = new JQueryUAHomePage(driver)
                .pageOpener()
                .shiftAlongXAndYAxis(xOffset, yOffset);

        logger.info(String.format("Moving draggble elament. It's shifted %s px along X and %s px along Y coordinate axis", draggableSimulator[0], draggableSimulator[1]));

        Assert.assertTrue(Math.abs(draggableSimulator[0]) > 0 && Math.abs(draggableSimulator[1]) > 0, "The draggable element wasn't moved at least along one of the axis");
    }
}