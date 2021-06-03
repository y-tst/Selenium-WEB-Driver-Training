package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static final int TIMEOUT_IN_SECONDS = 10;

    protected static WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract BasePage pageOpener();

    protected static void waitForPageLoad() {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {

                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(pageLoadCondition);
    }

    protected static boolean waitForElementVisibility(WebElement element) {
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();
    }
}