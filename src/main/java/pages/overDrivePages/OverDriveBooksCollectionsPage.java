package pages.overDrivePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class OverDriveBooksCollectionsPage extends BasePage {

    @FindBy(xpath = "//a[@href='/subjects/history']")
    private WebElement historicalBooks;

    public OverDriveBooksCollectionsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected OverDriveBooksCollectionsPage pageOpener(){
        return this;
    }

    public String booksCollectionPageTitle() {
        return driver.getTitle();
    }

    public OverDriveBooksCollectionsPage openHistoryBooks(){
        historicalBooks.click();

        return this;
    }
}