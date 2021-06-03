package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.logging.Logger;

public abstract class BaseTest {

    protected Logger logger = Logger.getGlobal();

    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("Chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
    }

    @AfterTest(alwaysRun=true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}