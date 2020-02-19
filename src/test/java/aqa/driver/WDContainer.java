package aqa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WDContainer {
    public final WebDriver driver;
    private final static WDContainer container = new WDContainer();

    private WDContainer() {
        driver = WDFactory.getDriver(DriverType.valueOf(System.getProperty("browser")));
    }

    public static WDContainer getContainer() {
        return container;
    }
}
