package pages.gismeteoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class GismeteoHomePage extends BasePage {

    private static final String GISMETEO_HOMEPAGE_URL = "https://gismeteo.ua/";

    @FindBy(xpath = "//a[@class='dropdown__handle']")
    private WebElement languageSelectorDropDown;

    @FindBy(xpath = "//a[@data-lang='ua']")
    private WebElement ukrainianLanguage;

    @FindBy(name = "q")
    private WebElement gismeteoSearchField;

    @FindBy(xpath = "//a[contains(@data-id,'4944')]")
    private WebElement firstSuggestionForSearch;

    public GismeteoHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GismeteoHomePage pageOpener() {
        driver.get(GISMETEO_HOMEPAGE_URL);

        waitForPageLoad();

        return this;
    }

    public String switchToLocaleUA() {
        languageSelectorDropDown.click();
        ukrainianLanguage.click();

        return driver.getCurrentUrl();
    }

    public GismeteoKyivWeatherPage searchForGismeteoTerm(String gismeteoSearchTerm) throws InterruptedException {
        waitForElementVisibility(gismeteoSearchField);
        gismeteoSearchField.sendKeys(gismeteoSearchTerm);
        waitForElementVisibility(firstSuggestionForSearch);
        retryingFindClick(firstSuggestionForSearch);

        return new GismeteoKyivWeatherPage(driver);
    }
}