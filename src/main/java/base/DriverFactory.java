package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {

        // LOCAL MACHINE: use explicit ChromeDriver path
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Projects\\drivers\\chromedriver-win64\\chromedriver.exe"
        );

        ChromeOptions options = new ChromeOptions();

        // CI / GitHub Actions safe settings
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }
}
