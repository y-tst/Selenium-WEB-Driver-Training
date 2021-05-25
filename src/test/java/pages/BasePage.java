package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static final int WAITING_PERIOD = 20;

    protected BasePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected WebDriver driver;

    protected abstract BasePage pageOpener();

    protected static void waiter(WebDriver driver) {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        WebDriverWait wait = new WebDriverWait(driver, WAITING_PERIOD);
        wait.until(pageLoadCondition);
    }
}
