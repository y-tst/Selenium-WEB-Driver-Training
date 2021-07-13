package pages.jQueryUIPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SearchResultPage extends BasePage {


    @FindBy(xpath = "//p[@class='desc']")
    private WebElement descriptionField;

    @FindBy(xpath = "//a[@tabindex='0']")
    private WebElement codeSource;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected SearchResultPage pageOpener() {
        return this;
    }

    public String functionDescription() {
        waitForElementVisibility(descriptionField);
        return descriptionField.getText();
    }

    public SearchResultPage openCodeSource(){
        waitForElementVisibility(codeSource);
        codeSource.click();

        return this;
    }
}