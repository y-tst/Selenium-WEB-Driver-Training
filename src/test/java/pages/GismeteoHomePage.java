package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GismeteoHomePage extends BasePage {

    public static final String GISMETEO_HOMEPAGE_URL = "https://gismeteo.ua/";

    @FindBy(xpath = "//a[@class='dropdown__handle']")
    private WebElement languageSelectorDropDown;

    @FindBy(xpath = "//a[@data-lang='ua']")
    private WebElement ukranianLanguage;

    @FindBy(name = "q")
    private WebElement gismeteoSearchField;

    @FindBy(xpath = "//div[@class='founditem__title']")
    private WebElement firstSugestionForSearch;

    public String gismeteoMainUApageURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public GismeteoHomePage pageOpener() {
        driver.get(GISMETEO_HOMEPAGE_URL);
        driver.manage().window().maximize();
        waiter(driver);
        return this;
    }

    public GismeteoHomePage(WebDriver driver) {
        super(driver);
    }

    public String switchToLocaleUA() {
        languageSelectorDropDown.click();
        ukranianLanguage.click();
        return driver.getCurrentUrl();
    }

    public GismeteoKyivWeatherPage searchForGismeteoTerm(String gismeteoSearchTerm) {
        gismeteoSearchField.sendKeys(gismeteoSearchTerm);
        firstSugestionForSearch.click();
        waiter(driver);
        return new GismeteoKyivWeatherPage(driver);
    }
}
