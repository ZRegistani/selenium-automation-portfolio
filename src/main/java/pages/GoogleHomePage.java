package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class GoogleHomePage {

    private final WebDriver driver;
    private final Waits waits;

    private final By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, 10);
    }

    public void open() {
        driver.get("https://www.google.com");
        waits.visible(searchBox);
    }

    public void search(String query) {
        waits.visible(searchBox).sendKeys(query + Keys.ENTER);
    }
}
