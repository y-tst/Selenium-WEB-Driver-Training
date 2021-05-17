package WebDriverSeleniumTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class googleSearchForWikiEdge {

    @Test
    public void GoogleSearchForWikiIsNotEmpty() throws IOException {

        final Logger logger = Logger.getGlobal();

        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();

        WebElement googleSearchField = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        googleSearchField.sendKeys("wikipedia");

        List<WebElement> googleSearchButton = driver.findElements(By.name("btnK"));
        googleSearchButton.get(0).submit();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'g') and contains(., 'wikipedia')]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'g') and contains(., 'wikipedia')]"));
        logger.info(String.format("Number of pages found: %s", searchResults.size()));

        Assert.assertTrue(searchResults.size() > 0, "Empty result for 'Wikipedia' search");

        WebElement firstWikiLinkFromGoogleSearch = new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='rso']//a/h3")));
        firstWikiLinkFromGoogleSearch.click();

        Assert.assertEquals(driver.getTitle(), "wikipedia - Пошук Google", "Different from the main Wiki page is opened");

        logger.info(String.format("Wiki page title is '%s', it has length: %s symbols", driver.getTitle(), driver.getTitle().length()));

        Assert.assertTrue(driver.getCurrentUrl().contains("wikipedia"), "Incorrect URL for Wiki page");

        logger.info(String.format("Wiki page length has %s symbols", driver.getPageSource().length()));

        WebElement didYouKnowPicture = driver.findElement(By.xpath ("(//div[contains(@id,'main-dyk')]//img)[1]"));
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

        logger.info(String.format("First picture from 'Did You Know' section - DidYouKnowPic1.png was screenshotted using standard Java classes and placed into 'target' folder"));

        WebElement element = driver.findElement(By.xpath ("(//div[contains(@id,'main-dyk')]//img)[2]"));
        Screenshot secondPictureInDidYuuKnow = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
        ImageIO.write(secondPictureInDidYuuKnow.getImage(), "jpg", new File("target/pictures/DidYouKnowPic2.jpg"));

        logger.info(String.format("Second picture from 'Did You Know' section - DidYouKnowPic2.png was screenshotted using AShot library and placed into 'target' folder"));

        WebElement wikiSearchField = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        wikiSearchField.sendKeys("Test Automation");
        wikiSearchField.submit();

        Assert.assertEquals(driver.getTitle(), "Поиск «Test Automation» — Википедия", "Search result doesn't contain 'Test automation'");

        logger.info(String.format("Wiki search for Test automation page result -  '%s'", driver.getTitle()));

        driver.quit();
    }
}
