package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.jQueryUIPages.JQueryUAHomePage;
import pages.jQueryUIPages.SearchResultPage;
import ru.yandex.qatools.allure.annotations.Step;
import service.DriverSingleton;

public class JQueryStepDefinitions {
    @Step("Step 1: Opening JQuery site")
    @Given("User opens JQuery site")
    public void openJQueryHomePage() {
        new JQueryUAHomePage(DriverSingleton.getDriverInstance()).pageOpener();
    }

    @Step("Step 2: Searching for needed functionality and selecting first suggestion")
    @When("User searches for {string} and selects first suggestion")
    public void userSearch(String searchTerm) {
        new JQueryUAHomePage(DriverSingleton.getDriverInstance()).fillInSearchField(searchTerm);
    }

    @Step("Step 3: Opening source code")
    @And("^Opens code source$")
    public void codeSource() {
        new SearchResultPage(DriverSingleton.getDriverInstance()).openCodeSource();
    }

    @Step("Step 4: Checking if the proper page is opened")
    @Then("Page contains proper {string}")
    public void pageContainsProperDescription(String expectedDescription) {
        String actualDescription = new SearchResultPage(DriverSingleton.getDriverInstance()).functionDescription();

        Assert.assertEquals(actualDescription, expectedDescription, "Description doesn't match proper function");
    }
}