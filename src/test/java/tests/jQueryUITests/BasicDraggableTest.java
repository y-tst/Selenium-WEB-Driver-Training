package tests.jQueryUITests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.jQueryUIPages.JQueryUAHomePage;
import tests.BaseTest;

public class BasicDraggableTest extends BaseTest {

    private int xOffset = 45;
    private int yOffset = 40;

    @Test
    public void basicDraggingCheck() {

        String draggedObjectPosition = new JQueryUAHomePage(driver)
                .pageOpener()
                .switchToDraggableSimulationPage()
                .shiftAlongXAndYAxis(xOffset, yOffset);

        logger.info(String.format("Moving draggable element. It's shifted on %s", draggedObjectPosition));

        Assert.assertNotEquals(draggedObjectPosition, "position: relative", "The draggable element wasn't moved");
    }
}