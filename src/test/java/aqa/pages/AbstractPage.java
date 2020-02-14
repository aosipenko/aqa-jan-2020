package aqa.pages;

import aqa.driver.WDContainer;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    private final String pageUrl;

    protected WebDriver driver = WDContainer.getContainer().driver;

    public AbstractPage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void loadPage() {
        driver.get(pageUrl);
    }
}
