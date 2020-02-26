package aqa.driver;

import aqa.pages.locators.ILocatable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class WebDriverFacade {

    private WebDriver driver;

    public WebDriverFacade(String driverType) {
        this.driver = WDFactory.getDriver(DriverType.valueOf(driverType));
    }

    public void loadPage(String url) {
        driver.get(url);
    }

    public void setElementText(ILocatable locatable, String value) {
        waitForElement(locatable.getLocator()).clear();
        waitForElement(locatable.getLocator()).sendKeys(value);
    }

    public void clickElement(By locator) {
        waitForElement(locator).click();
    }

    public WebElement waitForElement(By locator) {
        try {
            return new WebDriverWait(driver, 45)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void quitDriver() {
        driver.quit();
    }
}
