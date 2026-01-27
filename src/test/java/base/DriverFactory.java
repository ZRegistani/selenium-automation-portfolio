package base;

import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static final String CHROMEDRIVER_PATH =
            "C:\\Projects\\drivers\\chromedriver-win64\\chromedriver.exe";

    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);

        ChromeOptions options = new ChromeOptions();

        // ✅ Create a UNIQUE temp profile directory per test thread
        // This prevents "SessionNotCreatedException" in parallel runs.
        try {
            Path profileDir = Files.createTempDirectory("chrome-profile-");
            options.addArguments("--user-data-dir=" + profileDir.toAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create a temp Chrome profile directory", e);
        }

        // Optional stability flags (safe)
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        return new ChromeDriver(options);
    }
}
