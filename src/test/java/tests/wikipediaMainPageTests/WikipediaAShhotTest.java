package tests.wikipediaMainPageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.wikipediaPages.WikipediaHomePage;
import tests.BaseTest;

import java.io.IOException;

public class WikipediaAShhotTest extends BaseTest {

    @Test
    public void wikipediaImageIsValidCheck() throws IOException {

        int imageCapturedByAShot = new WikipediaHomePage(driver)
                .pageOpener()
                .pictureWidthAShot();

        logger.info(String.format("The picture from 'Did You Know' section - DidYouKnowPic2.png was captured using AShot library and placed into 'target' folder, the width is: %s px", imageCapturedByAShot));

        Assert.assertTrue(imageCapturedByAShot > 0, "The image doesn't exist");
    }
}