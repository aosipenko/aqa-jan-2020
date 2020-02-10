package aqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;

public class SeleniumSteps {

    private WebDriver driver;

    @Given("Load page google.com")
    public void loadGoogle() {
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @When("i search for {string}")
    public void searchInGoogle(String value) {
        driver.findElement(By.name("q")).sendKeys(value);
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    @Then("is see {string} in search results")
    public void validateSearch(String value) {
        List<WebElement> searchHeaders = driver.findElements(By.xpath("//h3"));
        assertFalse(searchHeaders.isEmpty());
        assertThat(searchHeaders.get(0).getText(), is(value));
    }

}
