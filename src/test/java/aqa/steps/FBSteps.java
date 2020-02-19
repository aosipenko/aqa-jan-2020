package aqa.steps;

import aqa.pages.FacebookPage;
import aqa.util.DataHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FBSteps {

    private String s;
    private FacebookPage facebookPage = new FacebookPage();

    @Given("Load FB page")
    public void loadFB() {
        facebookPage.loadPage();
    }

    @When("I search FB for {string}")
    public void searchFB(String param) {
        facebookPage.searchFB(param);
    }

    @Then("Print random number {string}")
    public void printNumber(String alias) {
        System.out.println(DataHolder.get(alias));
    }

}
