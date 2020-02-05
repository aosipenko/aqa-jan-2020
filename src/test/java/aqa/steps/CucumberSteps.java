package aqa.steps;

import com.jayway.restassured.response.ValidatableResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

public class CucumberSteps {
    HashMap<String, String> parameters = new HashMap();
    ValidatableResponse response;

    @Given("a rest api request with parameters: {string}")
    public void createApiRequest(String params) {
        parameters.put("inc", params);
        System.out.println("Passed params: " + parameters.size());
    }

    @When("i make request to randomuser.me")
    public void makeRestRequest() {
        System.out.println(parameters.size());
        //TODO: make Rest Assured call api with parameters map (see above)

    }

    @Then("i receive response with user data")
    public void checkRESTResponse() {
        //TODO: validate response
        System.out.println("Checking response!");
    }
}
