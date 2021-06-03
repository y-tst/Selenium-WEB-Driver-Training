package pages.gismeteoPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GismeteoKyivWeatherPage extends BasePage {

    @FindBy(xpath = "//a[@data-subnav-id='humidity\']")
    private WebElement gismeteoKyivHumidity;

    public GismeteoKyivWeatherPage(WebDriver driver) {
        super(driver);
    }

    public String searchResultPageTitle() {
        return driver.getTitle();
    }

    public String humidityNameOnKyivWeatherPage() {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", gismeteoKyivHumidity);
    }

    @Override
    protected GismeteoKyivWeatherPage pageOpener() {
        return this;
    }
}