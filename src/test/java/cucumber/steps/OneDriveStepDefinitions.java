package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.overDrivePages.OverDriveBooksCollectionsPage;
import pages.overDrivePages.OverDriveHistoricalBooksPage;
import pages.overDrivePages.OverDriveHomePage;
import service.DriverSingleton;

public class OneDriveStepDefinitions {
    @Given("User navigates OverDrive library home page")
    public void openOverDriveHomePage() {
        new OverDriveHomePage(DriverSingleton.getDriverInstance()).pageOpener();
    }

    @When("^User chooses Browse Collection item$")
    public void chooseBrowseCollectionItem() {
        new OverDriveHomePage(DriverSingleton.getDriverInstance()).openBooksCollectionsPage();
    }

    @And("^User clicks HISTORY button on the opened collections page$")
    public void clickGenreButton() {
        new OverDriveBooksCollectionsPage(DriverSingleton.getDriverInstance())
                .openHistoryBooks();
    }

    @Then("^Page with History title is opened$")
    public void openedPageTitle() {
        String genrePageTitle = new OverDriveHistoricalBooksPage(DriverSingleton.getDriverInstance()).historicalBooksPageTitle();

        Assert.assertEquals(genrePageTitle, "History", "The books from this page are not historical");
    }
}