package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static service.DriverSingleton.closeDriver;
import static service.DriverSingleton.getDriverInstance;

public class DriverHooks {

    protected static WebDriver driver;

    @Before
    public  void setupDriver(){
        driver = getDriverInstance();
    }

    @After
    public void quitDriver(){
        closeDriver();
    }
}