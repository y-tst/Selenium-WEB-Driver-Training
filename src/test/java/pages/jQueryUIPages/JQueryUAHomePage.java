package pages.jQueryUIPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class JQueryUAHomePage extends BasePage {

    private static final String JQUERYUI_HOMEPAGE_URL = "https://jqueryui.com/";

    @FindBy(xpath = "//a[@href='https://jqueryui.com/draggable/']")
    private WebElement draggableSubItem;

    @FindBy(xpath = "//a[@href='/resources/demos/draggable/default.html']")
    private WebElement basicFunctionalityCase;

    public JQueryUAHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public JQueryUAHomePage pageOpener() {
        driver.get(JQUERYUI_HOMEPAGE_URL);
        waitForPageLoad();

        return this;
    }

    public DraggableSimulationPage switchToDraggableSimulationPage() {
        draggableSubItem.click();
        waitForElementVisibility(basicFunctionalityCase);
        basicFunctionalityCase.click();
        waitForElementVisibility(draggableSubItem);

        waitForPageLoad();

        return new DraggableSimulationPage(driver);
    }

    public String draggableSimulatorURL() {
        draggableSubItem.click();

        return driver.getCurrentUrl();
    }
}