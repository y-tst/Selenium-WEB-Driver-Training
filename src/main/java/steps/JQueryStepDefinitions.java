package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.jQueryUIPages.JQueryUAHomePage;
import pages.jQueryUIPages.SearchResultPage;
import service.DriverSingleton;

public class JQueryStepDefinitions {
    @Given("User opens JQuery site")
    public void openJQueryHomePage() {
        new JQueryUAHomePage(DriverSingleton.getDriverInstance()).pageOpener();
    }

    @When("User searches for {string} and selects first suggestion")
    public void userSearch(String searchTerm) {
        new JQueryUAHomePage(DriverSingleton.getDriverInstance()).fillInSearchField(searchTerm);
    }

    @And("^Opens code source$")
    public void codeSource() {
        new SearchResultPage(DriverSingleton.getDriverInstance()).openCodeSource();
    }

    @Then("Page contains proper {string}")
    public void pageContainsProperDescription(String expectedDescription) {
        String actualDescription = new SearchResultPage(DriverSingleton.getDriverInstance()).functionDescription();

        Assert.assertEquals(actualDescription, expectedDescription, "Description doesn't match proper function");
    }
}