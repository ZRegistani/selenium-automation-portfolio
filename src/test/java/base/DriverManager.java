package base;

import org.openqa.selenium.WebDriver;
import base.DriverManager;


public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void unload() {
        driver.remove();
    }
}
