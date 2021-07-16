package tests.wikipediaMainPageTests;

import org.testng.Assert;
import pages.wikipediaPages.WikipediaHomePage;
import tests.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class WikipediaStandardScreenshotTest extends BaseTest {

    @Test
    public void wikipediaImageIsValidCheck() throws IOException {

        int imageCapturedByStandardScreenShot = new WikipediaHomePage(driver)
                .pageOpener()
                .pictureHeightStandardScreenshot();

        logger.info(String.format("The picture from 'Did You Know' section - DidYouKnowPic1.png was captured using standard Java classes and placed into 'target' folder, the heigt is: %s px", imageCapturedByStandardScreenShot));

        Assert.assertTrue(imageCapturedByStandardScreenShot > 0, "The image doesn't exist");
    }
}