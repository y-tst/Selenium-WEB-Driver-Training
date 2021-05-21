package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;

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

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoadCondition);
    }
}
