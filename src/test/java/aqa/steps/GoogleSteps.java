package aqa.steps;

import aqa.driver.WDContainer;
import aqa.pages.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSteps {

    private GooglePage googlePage = new GooglePage();

    @Given("Load page google.com")
    public void loadGoogle() {
        googlePage.loadPage();
    }

    @When("i search for {string} with {string}")
    public void searchInGoogle(String value, String searchButton) {
        googlePage.fillSearchForm(value);
        googlePage.pressSearchButton(searchButton);
    }

    @Then("is see {string} in search results")
    public void validateSearch(String value) {
        assertTrue(googlePage.validateSearchResults(value));
    }
}
