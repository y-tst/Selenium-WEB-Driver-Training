package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public abstract class BasePage {

    protected static final int TIMEOUT_IN_SECONDS = 10;

    protected static WebDriver driver;

    protected Logger logger = Logger.getGlobal();

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
        try {
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
        }
        catch (StaleElementReferenceException exception) {
            exception.getStackTrace();
        }

        return element.isEnabled();
    }

    public boolean retryingFindClick(WebElement webElement) throws InterruptedException {
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                webElement.click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
            Thread.sleep(250);
        }

        return result;
    }
}