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
        driver.manage().window().maximize();
        waitForPageLoad();

        return this;
    }

    public int pictureHeightStandardScreenshot() throws IOException {
        WebElement didYouKnowPicture = imageForStandardScreenshot;
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Point point = didYouKnowPicture.getLocation();
        int xcordinate = point.getX();
        int ycordinate = point.getY();
        int imageWidth = didYouKnowPicture.getSize().getWidth();
        int imageHeight = didYouKnowPicture.getSize().getHeight();
        BufferedImage img = ImageIO.read(screen);
        BufferedImage destination = img.getSubimage(xcordinate, ycordinate, imageWidth, imageHeight);
        ImageIO.write(destination, "png", screen);
        FileUtils.copyFile(screen, new File("target/pictures/DidYouKnowPic1.png"));

        return imageHeight;
    };

    public int pictureWidthAShot() throws IOException {
        WebElement element = imageForAShot;
        Screenshot secondPictureInDidYuuKnow = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element);
        ImageIO.write(secondPictureInDidYuuKnow.getImage(), "jpg", new File("target/pictures/DidYouKnowPic2.jpg"));

        return imageForAShot.getSize().getWidth();
    };

    public WikipediaSearchForTestAutomationResultsPage WikiSearchForTerms(String searchWikiTerm) {
        wikiSearchField.sendKeys(searchWikiTerm);
        wikiSearchField.submit();

        return new WikipediaSearchForTestAutomationResultsPage(driver);
    }
}