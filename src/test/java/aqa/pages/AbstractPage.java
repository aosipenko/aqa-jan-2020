package aqa.pages;

import aqa.driver.WebDriverFacade;

public abstract class AbstractPage {
    private final String pageUrl;

    public WebDriverFacade webDriverFacade;

    public AbstractPage(String pageUrl, WebDriverFacade webDriverFacade) {
        this.pageUrl = pageUrl;
        this.webDriverFacade = webDriverFacade;
    }

    public void loadPage() {
        webDriverFacade.loadPage(pageUrl);
    }
}
