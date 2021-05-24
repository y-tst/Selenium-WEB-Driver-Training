package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static final String GOOGLE_HOMEPAGE_URL = "https://www.google.com/";
    private static final int waitingPeriod = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    public void pageOpener(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        waiter(driver);
    }

    public static void waiter(WebDriver driver) {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, waitingPeriod);
        wait.until(pageLoadCondition);
    }

    public BasePage openGooglePage() {
        pageOpener(GOOGLE_HOMEPAGE_URL);
        return new GoogleHomePage(driver);
    }
}
