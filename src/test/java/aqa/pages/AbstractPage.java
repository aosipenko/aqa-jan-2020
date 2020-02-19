package aqa.pages;

import aqa.driver.WDContainer;
import aqa.driver.WebDriverFacade;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    private final String pageUrl;

    protected WebDriverFacade webDriver = new WebDriverFacade();

    public AbstractPage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void loadPage() {
        webDriver.loadPage(pageUrl);
    }
}
