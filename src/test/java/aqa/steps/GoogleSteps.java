package aqa.steps;

import aqa.pages.GooglePage;
import aqa.pages.locators.GoogleLocators;
import aqa.util.DataHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class GoogleSteps {

    @Autowired
    private GooglePage googlePage;

    @Given("Load page google.com")
    public void loadGoogle() {
        googlePage.loadPage();
    }

    @When("i search for {string} with {string}")
    public void searchInGoogle(String value, String searchButton) {
        googlePage.pressSearchButton(searchButton);
    }

    @Then("is see {string} in search results")
    public void validateSearch(String value) {
        assertTrue(googlePage.validateSearchResults(value));
    }

    @When("I set text of {} to {string}")
    public void setElementText(GoogleLocators locators, String value) {
        googlePage.fillTextElement(locators, value);
    }

    @Given("Generate random number {string}")
    public void generateNumber(String alias) {
        Random random = new Random();
        DataHolder.put(alias, random.nextInt(1000));
    }

    @Given("Add number {int} as {string}")
    public void addNumber(int num, String alias) {
        DataHolder.put(alias, num);
    }
}
