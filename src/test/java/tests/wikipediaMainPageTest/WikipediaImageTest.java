package tests.wikipediaMainPageTest;

import org.testng.Assert;
import pages.WikipediaHomePage;
import tests.BaseTest;
import org.testng.annotations.Test;

public class WikipediaImageTest extends BaseTest {

    @Test
    public void wikipediaImageIsValidCheck() {

        int imageCapturedByStandardScreenShot = new WikipediaHomePage(driver)
                .openWikipediaPage()
                .getImageHeightForStandardScreenShot();

        Assert.assertTrue(imageCapturedByStandardScreenShot > 0, "The image doesn't exist");

        logger.info(String.format("The picture from 'Did You Know' section - DidYouKnowPic1.png was captured using standard Java classes and placed into 'target' folder"));
    }
}

