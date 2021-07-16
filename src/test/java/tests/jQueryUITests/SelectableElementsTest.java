package tests.jQueryUITests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.jQueryUIPages.SelectableSerializePage;
import tests.BaseTest;

public class SelectableElementsTest extends BaseTest {

    @Test
    public void selectItemsFromSecondToFourthCheck() {

        String threeElementsSelectResult = new SelectableSerializePage(driver)
                .pageOpener()
                .selectableActionResult();

        logger.info(String.format("For selecting the Items from 2 to 4 (included), the result title is - 'You've selected: %s'", threeElementsSelectResult));

        Assert.assertEquals(threeElementsSelectResult, "#2 #3 #4", "Selecting is performed incorrectly");
    }
}