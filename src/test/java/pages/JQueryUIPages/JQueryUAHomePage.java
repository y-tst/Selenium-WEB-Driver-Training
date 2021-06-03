package pages.JQueryUIPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class JQueryUAHomePage extends BasePage {

    public static final String JQUERYUI_HOMEPAGE_URL = "https://jqueryui.com/";

    @FindBy(xpath = "//a[@href='https://jqueryui.com/draggable/']")
    private WebElement draggableSubItem;

    @FindBy(xpath = "//a[@href='/resources/demos/draggable/default.html']")
    private WebElement basicFunctionalityCase;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    private WebElement defaultDraggableFrame;

    @FindBy(xpath = "//div[@id=\'draggable\']")
    private WebElement defaultDraggableElement;

    public JQueryUAHomePage(WebDriver driver) {
        super(driver);
    }

    public String jQueryUAHomePageURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public JQueryUAHomePage pageOpener() {
        driver.get(JQUERYUI_HOMEPAGE_URL);
        driver.manage().window().maximize();
        waitForPageLoad();

        return this;
    }

    public String draggableSimulatorURL() {
        draggableSubItem.click();

        return driver.getCurrentUrl();
    }

    public int[] shiftAlongXAndYAxis(int shiftAlongX, int shiftAlongY) throws InterruptedException {
        int xPositionInitial, yPositionInitial;
        int xPositionMoved, yPositionMoved;

        draggableSubItem.click();
        basicFunctionalityCase.click();

        waitForElementVisibility(defaultDraggableFrame);
        driver.switchTo().frame(defaultDraggableFrame);

        waitForElementVisibility(defaultDraggableElement);
        xPositionInitial = defaultDraggableElement.getLocation().getX();
        yPositionInitial = defaultDraggableElement.getLocation().getY();

        Thread.sleep(3000);

        new Actions(driver).dragAndDropBy(defaultDraggableElement, shiftAlongX, shiftAlongY).build().perform();

        Thread.sleep(3000);

        xPositionMoved = defaultDraggableElement.getLocation().getX();
        yPositionMoved = defaultDraggableElement.getLocation().getY();

        return new int[]{(xPositionInitial - xPositionMoved), (yPositionInitial - yPositionMoved)};
    }
}