package tests.jQueryUITests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.jQueryUIPages.SortablePlaceholderPage;
import tests.BaseTest;

public class MovingSortableElementTest extends BaseTest {

    @Test
    public void moveFirstItemToPlaceOfThird() {

        String firstItemNameAfterMoving = new SortablePlaceholderPage(driver)
                .pageOpener()
                .firstItemOfTheListToThird();

        logger.info(String.format("After moving the first element of the list to third place, the name of new first one is %s", firstItemNameAfterMoving));

        Assert.assertEquals(firstItemNameAfterMoving, "Item 2", "Moving is incorrect");
    }
}