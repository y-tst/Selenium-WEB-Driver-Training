package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import service.DriverSingleton;
import service.TestListener;

import java.util.logging.Logger;

@Listeners({TestListener.class})

public abstract class BaseTest {

    protected Logger logger = Logger.getGlobal();

    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriverInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}