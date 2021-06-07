package pages.jQueryUIPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DraggableSimulationPage extends BasePage {
    private WebElement basicFunctionalityCase;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    private WebElement defaultDraggableFrame;

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement defaultDraggableElement;

    public DraggableSimulationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected DraggableSimulationPage pageOpener() {
        return this;
    }

    public String shiftAlongXAndYAxis(int shiftAlongX, int shiftAlongY) {

        JavascriptExecutor jsHighlighterForFrame = (JavascriptExecutor) driver;
        jsHighlighterForFrame.executeScript("arguments[0].style.border='3px solid red'", defaultDraggableFrame);

        driver.switchTo().frame(defaultDraggableFrame);

        JavascriptExecutor jsHighlighterForItem = (JavascriptExecutor) driver;
        jsHighlighterForItem.executeScript("arguments[0].style.background='yellow'", defaultDraggableElement);

        new Actions(driver).dragAndDropBy(defaultDraggableElement, shiftAlongX, shiftAlongY).build().perform();

        return defaultDraggableElement.getAttribute("style");
    }
}