package pages.gismeteoPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GismeteoKyivWeatherPage extends BasePage {

    @FindBy(xpath = "(//span[@property='name'])[2]")
    private WebElement gismeteoKyivPageSubtitle;

    public GismeteoKyivWeatherPage(WebDriver driver) {
        super(driver);
    }

    public String searchResultPageTitle() {
        return driver.getTitle();
    }

    public String gismeteoPageSubtitle() {
        waitForElementVisibility(gismeteoKyivPageSubtitle);
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", gismeteoKyivPageSubtitle);
    }

    @Override
    protected GismeteoKyivWeatherPage pageOpener() {
        return this;
    }
}