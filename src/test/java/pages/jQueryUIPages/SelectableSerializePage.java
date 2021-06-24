package pages.jQueryUIPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class SelectableSerializePage extends BasePage {

    private static final String SELECTABLE_SERIALIZE_URL = "https://jqueryui.com/selectable/#serialize";

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    private WebElement frameElement;

    @FindBy(xpath = "//span[@id = 'select-result']")
    private WebElement selectableResumeElement;

    @FindAll({@FindBy(xpath = "//li[@class='ui-widget-content ui-selectee']")})
    private  List<WebElement> selectableList;

    public SelectableSerializePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SelectableSerializePage pageOpener() {
        driver.get(SELECTABLE_SERIALIZE_URL);
        waitForPageLoad();

        return this;
    }

    public String selectableActionResult() {

        driver.switchTo().frame(frameElement);
        waitForElementVisibility(selectableResumeElement);

        new Actions(driver).clickAndHold(selectableList.get(1))
                .moveToElement(selectableList.get(3))
                .release()
                .build()
                .perform();

        logger.info(String.format("Sortable list size is %s items", selectableList.size()));

        return selectableResumeElement.getText();
    }
}