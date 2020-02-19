package aqa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WDFactory {

    private WDFactory() {
    }

    public static WebDriver getDriver(DriverType type) {
        if (DriverType.CHROME.equals(type)) {
            return createChromeDriver();
        } else {
            return createFFDriver();
        }
    }

    private static ChromeDriver createChromeDriver() {
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver();
    }

    private static FirefoxDriver createFFDriver() {
        WebDriverManager manager = WebDriverManager.firefoxdriver();
        manager.setup();
        return new FirefoxDriver();
    }
}
