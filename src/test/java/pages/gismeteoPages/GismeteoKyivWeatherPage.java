package pages.gismeteoPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GismeteoKyivWeatherPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement gismeteoKyivPageTitle;

    public GismeteoKyivWeatherPage(WebDriver driver) {
        super(driver);
    }

    public String searchResultPageTitle() {
        return driver.getTitle();
    }

    public String kyivWeatherPageAknowledge() {
        return gismeteoKyivPageTitle.getText();
    }

    @Override
    protected GismeteoKyivWeatherPage pageOpener() {
        return this;
    }
}