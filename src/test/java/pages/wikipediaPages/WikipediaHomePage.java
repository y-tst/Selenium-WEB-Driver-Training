package pages.wikipediaPages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WikipediaHomePage extends BasePage {

    private static final String WIKIPEDIA_HOMEPAGE_URL = "https://ru.wikipedia.org";

    @FindBy(name = "search")
    private WebElement wikiSearchField;

    @FindBy(xpath = "(//div[contains(@id,'main-dyk')]//img)[1]")
    private WebElement imageForStandardScreenshot;

    @FindBy(xpath = "(//div[contains(@id,'main-dyk')]//img)[2]")
    private WebElement imageForAShot;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WikipediaHomePage pageOpener() {
        driver.get(WIKIPEDIA_HOMEPAGE_URL);
        waitForPageLoad();
        return this;
    }

    public int pictureHeightStandardScreenshot() throws IOException {
        waitForElementVisibility(imageForStandardScreenshot);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Point point = imageForStandardScreenshot.getLocation();
        BufferedImage img = ImageIO.read(screen);
        BufferedImage destination = img.getSubimage(point.getX(), point.getY(), imageForStandardScreenshot.getSize().getWidth(), imageForStandardScreenshot.getSize().getHeight());
        ImageIO.write(destination, "png", screen);
        FileUtils.copyFile(screen, new File("target/pictures/DidYouKnowPic1.png"));

        return  imageForStandardScreenshot.getSize().getHeight();
    };

    public int pictureWidthAShot() throws IOException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        waitForElementVisibility(imageForAShot);
        Screenshot secondPictureInDidYouKnow = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, imageForAShot);
        ImageIO.write(secondPictureInDidYouKnow.getImage(), "png", screen);
        FileUtils.copyFile(screen, new File("target/pictures/DidYouKnowPic2.png"));

        return secondPictureInDidYouKnow.getImage().getWidth();
    };

    public WikipediaSearchForTestAutomationResultsPage WikiSearchForTerms(String searchWikiTerm) {
        wikiSearchField.sendKeys(searchWikiTerm);
        wikiSearchField.submit();

        return new WikipediaSearchForTestAutomationResultsPage(driver);
    }
}