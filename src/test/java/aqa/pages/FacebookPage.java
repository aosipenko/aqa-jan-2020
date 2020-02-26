package aqa.pages;

import aqa.driver.WebDriverFacade;
import org.springframework.stereotype.Component;

@Component
public class FacebookPage extends AbstractPage {

    private final static String URL = "https://facebook.com/";

    public FacebookPage(WebDriverFacade webDriverFacade) {
        super(URL, webDriverFacade);
    }

    public void searchFB(String value) {
        //todo: implement fb search
    }

}
