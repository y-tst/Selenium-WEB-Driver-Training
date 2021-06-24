package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import service.TestListener;

import java.util.logging.Logger;

@Listeners({TestListener.class})

public abstract class BaseTest {

    protected Logger logger = Logger.getGlobal();

    protected static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("Chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().window().maximize();
    };

    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        driver.switchTo().defaultContent();
        driver.quit();
        driver = null;
    }
}