package aqa.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;

public class CucumberSteps {
    private final static String URL = "https://randomuser.me/api/";
    HashMap<String, String> parameters = new HashMap();
    ValidatableResponse response;

    @Given("Set request parameter {string} as {string}")
    public void setRequestParameter(String key, String value){
        parameters.put(key, value);
    }

    @When("i make request to randomuser.me")
    public void makeRestRequest() {
        response = RestAssured.given().queryParams(parameters).get(URL).then();
    }

    @Then("i receive response with user data with value {string}")
    public void checkRESTResponse(String value) {
        assertNotNull(response);
        response.statusCode(200).content(containsString(value));
    }
}
