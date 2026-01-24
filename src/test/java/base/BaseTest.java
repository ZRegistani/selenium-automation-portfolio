package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        // Optional temp override (VALID Java syntax)
        System.setProperty("java.io.tmpdir", "C:\\Projects\\tmp");
        System.setProperty("TEMP", "C:\\Projects\\tmp");
        System.setProperty("TMP", "C:\\Projects\\tmp");

        WebDriver driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverManager.unload();
    }
}
