package pages.jQueryUIPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class SortablePlaceholderPage extends BasePage {

    private static final String SORTABLE_PLACEHOLDER_URL = "https://jqueryui.com/sortable/#placeholder";

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    private WebElement frameElement;

    @FindBy(xpath = "//ul[@id = 'sortable']")
    private WebElement sortableElement;

    @FindAll({@FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")})
    private  List<WebElement> sortableList;

    public SortablePlaceholderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SortablePlaceholderPage pageOpener() {
        driver.get(SORTABLE_PLACEHOLDER_URL);
        waitForPageLoad();

        return this;
    }

    public String firstItemOfTheListToThird() {

        driver.switchTo().frame(frameElement);
        waitForElementVisibility(sortableElement);

        new Actions(driver).dragAndDropBy(sortableList.get(0), 0, 140)
                .build()
                .perform();

        logger.info(String.format("Sortable list size is %s items", sortableList.size()));

        return sortableList.get(0).getText();
    }
}