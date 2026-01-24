package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;

public class DriverFactory {

    private static final String CHROMEDRIVER_PATH =
            "C:\\Projects\\drivers\\chromedriver-win64\\chromedriver.exe";

    public static WebDriver createDriver() {

        if (!Files.exists(Path.of(CHROMEDRIVER_PATH))) {
            throw new RuntimeException("ChromeDriver not found at: " + CHROMEDRIVER_PATH);
        }

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);

        // Create a clean, writable Chrome profile folder (prevents profile lock / permission issues)
        String userDataDir = "C:\\Projects\\chrome-profile";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=" + userDataDir);
        options.addArguments("--profile-directory=Default");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }
}
