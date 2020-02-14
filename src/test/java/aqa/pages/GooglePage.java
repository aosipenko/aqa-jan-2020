package aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends AbstractPage {

    private final static String URL = "https://google.com";

    @FindBy(name = "q")
    public WebElement searchField;

    @FindBy(id = "search_form_input_homepage")
    public WebElement duckSearchField;

    public GooglePage() {
        super(URL);
    }

    public void fillSearchForm(String value) {
        searchField.sendKeys(value);
    }

    public void pressSearchButton(String searchType) {
        if ("General".equalsIgnoreCase(searchType)) {
            //TODO: make general search work
        } else if ("Return".equalsIgnoreCase(searchType)) {
            searchField.sendKeys(Keys.RETURN);
        } else if ("Lucky".equalsIgnoreCase(searchType)) {
            driver.findElement(By.name("btnI")).click();
        } else {
            //TODO: make drop-down search work
        }
    }

    public void openMenu() {
        driver.findElement(By.xpath("//*[@title='Google apps']")).click();
    }

    public void selectMenuItem(String itemName) {

    }

    public boolean validateSearchResults(String value) {
        return true;
    }

}
