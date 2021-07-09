package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import service.DriverSingleton;

public class DriverHooks {

    protected static WebDriver driver;

    @Before
    public  void setupDriver(){
        driver = DriverSingleton.getDriverInstance();
    }

    @After
    public void quitDriver(){
        DriverSingleton.closeDriver();
    }
}
