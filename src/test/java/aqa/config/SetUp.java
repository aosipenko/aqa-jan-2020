package aqa.config;

import aqa.driver.WebDriverFacade;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath*:spring/spring-context.xml")
public class SetUp {

    @Autowired
    private WebDriverFacade webDriverFacade;

    @Before
    public void startUp() {

    }

    @After
    public void shutDown() {
        webDriverFacade.quitDriver();
    }
}
