package aqa.pages.locators;

import org.openqa.selenium.By;

public enum GoogleLocators implements ILocatable {

    SEARCH_FIELD(By.name("q")),
    SEARCH_BTN(By.name("btnI"));

    private By locator;

    GoogleLocators(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
