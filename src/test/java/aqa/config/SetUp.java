package aqa.config;

import aqa.driver.WDContainer;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetUp {

    @Before
    public void startUp() {

    }

    @After
    public void shutDown() {
        WDContainer.getContainer().driver.quit();
    }
}
