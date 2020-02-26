package aqa.pages;

import aqa.driver.WebDriverFacade;
import aqa.pages.locators.ILocatable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends AbstractPage {

    private final static String URL = "https://google.com";

    @FindBy(id = "search_form_input_homepage")
    public WebElement duckSearchField;

    public GooglePage(WebDriverFacade webDriverFacade) {
        super(URL, webDriverFacade);
    }

    public void fillTextElement(ILocatable locatable, String value) {
        webDriverFacade.setElementText(locatable, value);
    }

    public void pressSearchButton(String searchType) {
        if ("General".equalsIgnoreCase(searchType)) {
            //TODO: make general search work
        } else if ("Return".equalsIgnoreCase(searchType)) {
//            searchField.sendKeys(Keys.RETURN);
        } else if ("Lucky".equalsIgnoreCase(searchType)) {
            webDriverFacade.clickElement(By.name("bntI"));
        } else {
            //TODO: make drop-down search work
        }
    }

    public void openMenu() {
//        driver.findElement(By.xpath("//*[@title='Google apps']")).click();
    }

    public void selectMenuItem(String itemName) {

    }

    public boolean validateSearchResults(String value) {
        return true;
    }

}
