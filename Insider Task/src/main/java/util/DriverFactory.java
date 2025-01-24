package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static PropertiesReader propertiesReader = new PropertiesReader();

    public static WebDriver setDriver(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().clearDriverCache();
                WebDriverManager.chromedriver().clearResolutionCache();
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(new ChromeDriver());
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().clearDriverCache();
                WebDriverManager.firefoxdriver().clearResolutionCache();
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                break;
            default:
                Assert.fail("The requested value was not entered!" + browser);
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesReader.getImplicityWait()));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(propertiesReader.getPageLoadTimeout()));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(propertiesReader.getUrl());
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

}
